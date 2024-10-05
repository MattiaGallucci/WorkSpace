package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Snake3D extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private static final int SNAKE_SPEED = 10;

    private static final int FIELD_SIZE = 100;

    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final Color SNAKE_COLOR = Color.GREEN;
    private static final Color FOOD_COLOR = Color.RED;

    private Camera camera;
    private Snake snake;
    private Food food;

    public Snake3D() {
        super("Snake 3D");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        camera = new Camera(WINDOW_WIDTH, WINDOW_HEIGHT);
        snake = new Snake(FIELD_SIZE, SNAKE_COLOR);
        food = new Food(FIELD_SIZE, FOOD_COLOR);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        snake.setDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        snake.setDirection(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        snake.setDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        snake.setDirection(Direction.RIGHT);
                        break;
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    snake.grow();
                }
            }
        });

        render();
    }

    private void render() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Disegna lo sfondo
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Disegna il serpente
        snake.render(g, camera);

        // Disegna il cibo
        food.render(g, camera);
    }

    private void update() {
        snake.update();

        // Verifica se il serpente si è scontrato con se stesso o con il bordo
        if (snake.collides()) {
            gameOver();
        }

        // Verifica se il serpente ha mangiato il cibo
        if (snake.eats(food)) {
            food.respawn();
            snake.grow();
        }
    }

    private void gameOver() {
        // Sospendi il timer
        // Visualizza un messaggio di game over
        // Chiudi la finestra
    }

    public static void main(String[] args) {
        new Snake3D().setVisible(true);
    }
}
