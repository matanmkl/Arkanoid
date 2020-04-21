package Executables;

import Game.Objects.Ball;
import Game.Velocity;
import Geometry.Point;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

@SuppressWarnings("InfiniteLoopStatement")
public class BallsTest1 {
    private static void drawAnimation() {
        GUI gui = new GUI("title", 200, 200);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        java.util.Random rand = new java.util.Random();
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            Ball ball = new Ball(rand.nextInt(200), rand.nextInt(200), 30, java.awt.Color.BLACK);
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

    private static void drawMovingAnimation(Point start, double angle, double speed) {
        GUI gui = new GUI("title", 400, 400);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), 50, java.awt.Color.BLACK);
        ball.setVelocity(Velocity.fromAngleAndSpeed(angle, speed));
        ball.setGameBorders(new Point(0, 0), new Point(400, 400));
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(20);  // wait for 50 milliseconds.
        }
    }

    private static void drawStaticBalls() {
        GUI gui = new GUI("Balls Test 1", 400, 400);
        DrawSurface d = gui.getDrawSurface();

        Ball b1 = new Ball(100, 100, 30, java.awt.Color.RED);
        Ball b2 = new Ball(100, 150, 10, java.awt.Color.BLUE);
        Ball b3 = new Ball(80, 249, 50, java.awt.Color.GREEN);

        b1.drawOn(d);
        b2.drawOn(d);
        b3.drawOn(d);

        gui.show(d);
    }

    public static void main(String[] args) {
        drawMovingAnimation(new Point(200, 200), 92, 15);
    }

}