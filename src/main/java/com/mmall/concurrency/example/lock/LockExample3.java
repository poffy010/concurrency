package com.mmall.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.StampedLock;

/**
 * @author Poffy Zhang
 * @date 2021/8/13 14:54
 * @desc
 */
@Slf4j
public class LockExample3 {
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

   double distanceFromOrigin() { // A read-only method
      long stamp = sl.tryOptimisticRead();
      double currentX = x, currentY = y;
      if (!sl.validate(stamp)) {
        stamp = sl.readLock();
         try {
           currentX = x;
           currentY = y;
         } finally {
            sl.unlockRead(stamp);
         }
      }
      return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    void moveIfAtOrigin(double newX, double newY) { // upgrade
      // Could instead start with optimistic, not read mode
      long stamp = sl.readLock();
      try {
        while (x == 0.0 && y == 0.0) {
          long ws = sl.tryConvertToWriteLock(stamp);
         if (ws != 0L) {
            stamp = ws;
            x = newX;
            y = newY;
            break;
          }
          else {
            sl.unlockRead(stamp);
            stamp = sl.writeLock();
          }
        }
      } finally {
        sl.unlock(stamp);
      }
    }

    @Test
    public void test() {
        log.info("before x:{},y:{}",x,y);
        move(1.0,2.0);
        log.info("1-after x:{},y:{}",x,y);
        distanceFromOrigin();
        log.info("2-after x:{},y:{}",x,y);
        moveIfAtOrigin(1.0,2.0);
        log.info("3-after x:{},y:{}",x,y);
    }
}
