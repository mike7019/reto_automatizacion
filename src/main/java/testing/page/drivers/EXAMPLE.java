package testing.page.drivers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EXAMPLE extends JFrame implements ActionListener {
    JDesktopPane desktop;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem newItem, exitItem;

    public EXAMPLE() {
        super("MDI Example");

        // Create the desktop pane
        desktop = new JDesktopPane();

        // Set the menu bar
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        newItem = new JMenuItem("New");
        exitItem = new JMenuItem("Exit");

        newItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(newItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Add the desktop pane to the frame
        getContentPane().add(desktop, BorderLayout.CENTER);

        // Set the size and show the frame
        setSize(800, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem) {
            // Create a new internal frame
            JInternalFrame frame = new JInternalFrame("New Window", true, true, true, true);
            frame.setSize(300, 200);
            frame.setLocation(50, 50);

            // Create the dropdown list and grid with horizontal slider
            String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
            JComboBox<String> comboBox = new JComboBox<>(items);
            JTable table = new JTable(5, 3);
            JScrollPane scrollPane = new JScrollPane(table);
            JScrollBar horizontalScrollBar = new JScrollBar(JScrollBar.HORIZONTAL);

            // Add the components to the frame
            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(comboBox, BorderLayout.NORTH);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.getContentPane().add(horizontalScrollBar, BorderLayout.SOUTH);

            // Add the internal frame to the desktop
            desktop.add(frame);
            frame.setVisible(true);
        } else if (e.getSource() == exitItem) {
            // Exit the application
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new EXAMPLE();
    }
}