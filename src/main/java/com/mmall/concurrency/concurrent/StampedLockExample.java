package com.mmall.concurrency.concurrent;


import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    class Point {
        private double x, y;
        private final StampedLock sl = new StampedLock();

        void move(double deltaX, double deltaY) { // an exclusively locked method
            long stamp = sl.writeLock();
            try {
                x += deltaX;
                y += deltaY;
            } finally {
                sl.unlockWrite(stamp);
            }
        }

        // 乐观读锁
        double distanceFromOrigin() { // A read-only method
            long stamp = sl.tryOptimisticRead(); // 获取一个乐观锁
            double currentX = x, currentY = y;// 将两个变量读入到本地局部变量
            if (!sl.validate(stamp)) {// 检查发出乐观读锁后同时是否有其他写锁发生
                stamp = sl.readLock();// 如果没有，我们再次获得一个读悲观锁
                try {
                    currentX = x;// 将两个变量读入到本地局部变量
                    currentY = y;// 将两个变量读入到本地局部变量
                } finally {
                    sl.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }

        // 悲观读锁
        void moveIfAtOrigin(double newX, double newY) { // upgrade
            // Could instead start with optimistic, not read mode
            long stamp = sl.readLock();
            try {
                while (x == 0.0 && y == 0.0) { // 循环,检查当前状态是否符合
                    long ws = sl.tryConvertToWriteLock(stamp);// 将读锁转换成写锁
                    if (ws != 0L) { // 判断是否转为写锁成功
                        stamp = ws;// 如果成功 替换票据
                        x = newX; // 进行状态改变
                        y = newY;// 进行状态改变
                        break;
                    } else { // 如果不能成功转化为写锁
                        sl.unlockRead(stamp); // 我们显示释放读锁
                        stamp = sl.writeLock();// 显示直接进行写锁 然后在通过循环再试
                    }
                }
            } finally {
                sl.unlock(stamp); // 释放读锁或则写锁
            }
        }
    }
}
