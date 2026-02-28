package com.hector.titulacionpredial.view.swing.menu;

import com.hector.titulacionpredial.view.swing.model.ModelMenuItem;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Grupo de menú con submenús expandibles.
 *
 * <p>
 * Contiene un elemento principal ({@link Item}) y una lista
 * de sub-elementos que se despliegan con animación al hacer
 * clic. Utiliza MigLayout para organizar los sub-ítems.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 * @see Item
 * @see ModelMenuItem
 */
public class MenuItem extends JPanel {

    private final List<EventMenuSelected> events = new ArrayList<>();
    private final int index;
    private final boolean hasSubMenu;
    private Animator animator;
    private int buttonAngle = -1;
    private boolean open;

    public MenuItem(ModelMenuItem item, int index, MigLayout layout) {
        this.index = index;
        this.hasSubMenu = item.getSubMenu().length > 0;
        init(item);

        if (hasSubMenu) {
            initAnimator(layout);
            buttonAngle = 0;
        }
    }

    private void init(ModelMenuItem item) {
        setOpaque(false);
        setForeground(new Color(170, 170, 170));
        setLayout(new MigLayout("wrap,fillx,inset 0", "[fill]", "[fill,35!]" + (hasSubMenu ? "0[fill,30!]" : "")));

        Item menu = new Item(true, 0);
        menu.setCustomIcon(item.getIcon());
        menu.setText("  " + item.getMenuName());

        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setForeground(menu.getMainColor());
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                if (!menu.isSelected()) {
                    setForeground(new Color(170, 170, 170));
                }
            }
        });

        menu.addActionListener(evt -> runEvent(index, 0));

        if (hasSubMenu) {
            menu.addActionListener(evt -> {
                open = !open;
                startAnimator();
            });
        }

        add(menu);
        int subIndex = 0;

        for (String subMenu : item.getSubMenu()) {
            Item sMenu = new Item(false, ++subIndex);
            sMenu.setText(subMenu);
            sMenu.addActionListener(e -> runEvent(index, sMenu.getIndex()));
            add(sMenu);
        }
    }

    private void initAnimator(MigLayout layout) {
        animator = new Animator(300, new TimingTargetAdapter() {
            private int height;

            @Override
            public void begin() {
                height = getPreferredSize().height - 35;
            }

            @Override
            public void timingEvent(float fraction) {
                float f = open ? fraction : 1f - fraction;
                int s = (int) (35 + f * height);
                layout.setComponentConstraints(MenuItem.this, "h " + s + "!");
                buttonAngle = (int) (f * 180);
                revalidate();
                repaint();
            }
        });

        animator.setResolution(0);
        animator.setDeceleration(.5f);
        animator.setAcceleration(.5f);
    }

    private void startAnimator() {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }

        animator.start();
    }

    public void addEvent(EventMenuSelected event) {
        this.events.add(event);
    }

    private void runEvent(int index, int subIndex) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, subIndex);
        }
    }

    public int getIndex() {
        return index;
    }

    public boolean isHasSubMenu() {
        return hasSubMenu;
    }

    public void clearSelected() {
        setForeground(new Color(170, 170, 170));

        for (Component com : getComponents()) {
            Item item = (Item) com;
            item.setSelected(false);
        }
    }

    public void setSelectedIndex(int index) {
        for (Component com : getComponents()) {
            Item item = (Item) com;

            if (item.isMainMenu()) {
                item.setSelected(true);
                setForeground(item.getMainColor());
            }

            if (item.getIndex() == index) {
                item.setSelected(true);
                break;
            }
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (buttonAngle >= 0) {
            Graphics2D g2 = (Graphics2D) graphics.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getForeground());
            int x = getWidth() - 25;
            int y = 15;

            Path2D p2 = new Path2D.Double();
            p2.moveTo(x, y);
            p2.lineTo(x + 4, y + 4);
            p2.lineTo(x + 8, y);

            AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(buttonAngle), x + 4, y + 2);
            g2.setStroke(new BasicStroke(1.8f));
            g2.draw(at.createTransformedShape(p2));
            g2.dispose();
        }
    }

}
