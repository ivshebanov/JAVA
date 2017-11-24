package com.javarush.task.task35.task3513;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private static final Color BG_COLOR = new Color(0xbbada0);
    private static final String FONT_NAME = "Arial";
    private static final int TILE_SIZE = 96;
    private static final int TILE_MARGIN = 12;

    private Controller controller;

    boolean isGameWon = false;
    boolean isGameLost = false;

    /**
     * Констректор.
     */
    public View(Controller controller) {
        setFocusable(true);
        this.controller = controller;
        addKeyListener(controller);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(BG_COLOR);
        graphics.fillRect(0, 0, this.getSize().width, this.getSize().height);
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                drawTile(graphics, controller.getGameTiles()[y][x], x, y);
            }
        }

        graphics.drawString("Score: " + controller.getScore(), 140, 465);

        if (isGameWon) {
            JOptionPane.showMessageDialog(this, "You've won!");
        } else if (isGameLost) {
            JOptionPane.showMessageDialog(this, "You've lost :(");
        }
    }

    private void drawTile(Graphics graphics, Tile tile, int x, int y) {
        Graphics2D graphics2D = ((Graphics2D) graphics);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int value = tile.value;
        int xOffSet = offsetCoors(x);
        int yOffSet = offsetCoors(y);
        graphics2D.setColor(tile.getTileColor());
        graphics2D.fillRoundRect(xOffSet, yOffSet, TILE_SIZE, TILE_SIZE, 8, 8);
        graphics2D.setColor(tile.getFontColor());
        final int size = value < 100 ? 36 : value < 1000 ? 32 : 24;
        final Font font = new Font(FONT_NAME, Font.BOLD, size);
        graphics2D.setFont(font);

        String stringValue = String.valueOf(value);
        final FontMetrics fm = getFontMetrics(font);

        final int w = fm.stringWidth(stringValue);
        final int h = -(int) fm.getLineMetrics(stringValue, graphics2D).getBaselineOffsets()[2];

        if (value != 0) {
            graphics2D.drawString(stringValue,
                    xOffSet + (TILE_SIZE - w) / 2,
                    yOffSet + TILE_SIZE - (TILE_SIZE - h) / 2 - 2);
        }
    }

    private static int offsetCoors(int arg) {
        return arg * (TILE_MARGIN + TILE_SIZE) + TILE_MARGIN;
    }
}
