package testing.page.drivers;

import javax.swing.*;
import java.awt.*;

public class MDIExample extends JFrame {

    private JDesktopPane desktop;

    public MDIExample() {
        super("MDI Example");

        // Create the desktop pane
        desktop = new JDesktopPane();

        // Create the internal frames
        createInternalFrame("Window 1", 20, 50);
        createInternalFrame("Window 2", 320, 50);
        createInternalFrame("Window 3", 620, 50);
        createInternalFrame("Window 4", 920, 50);

        // Set the size and position of the main window
        setSize(1250, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the desktop pane to the main window
        getContentPane().add(desktop, BorderLayout.CENTER);
    }

    private void createInternalFrame(String title, int x, int y) {
        // Create the internal frame
        JInternalFrame frame = new JInternalFrame(title, true, true, true, true);
        frame.setSize(280, 400);
        frame.setLocation(x, y);

        // Create the dropdown list and grid with horizontal slider
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        JTable table = new JTable(5, 3);
        JScrollPane scrollPane = new JScrollPane(table);
        JScrollBar horizontalScrollBar = new JScrollBar(JScrollBar.HORIZONTAL);

        // Set the layout manager for the content pane
        GridBagLayout layout = new GridBagLayout();
        frame.getContentPane().setLayout(layout);

        // Specify the constraints for the components
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(10, 10, 0, 10); // top, left, bottom, right
        frame.getContentPane().add(comboBox, c);

        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(10, 10, 10, 10); // top, left, bottom, right
        frame.getContentPane().add(scrollPane, c);

        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 10, 10, 10); // top, left, bottom, right
        frame.getContentPane().add(horizontalScrollBar, c);

        // Add the internal frame to the desktop
        desktop.add(frame);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MDIExample().setVisible(true));
    }
}