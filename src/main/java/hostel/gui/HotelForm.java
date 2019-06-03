package main.java.hostel.gui;

import main.java.hostel.domain.entity.Employee;
import main.java.hostel.domain.entity.Guest;
import main.java.hostel.domain.entity.Volunteer;
import main.java.hostel.services.EmployeeService;
import main.java.hostel.services.GuestService;
import main.java.hostel.services.VolunteerService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HotelForm {
    private JPanel mainPanel;
    private JButton allEmployees;
    private JButton allVolunteers;
    private JButton allGuests;
    private JButton searchGuestByCnp;
    private JButton searchGuestByOriginCountry;
    private JTable resultTable;
    private JTabbedPane mainPage;
    private JTextPane text;


    public HotelForm() {

        allEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Employee>, String> stringSwingWorker = new SwingWorker<List<Employee>, String>() {
                    @Override
                    protected List<Employee> doInBackground() throws Exception {

                        EmployeeService employeeService = new EmployeeService();
                        return employeeService.getEmployees();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Employee> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Name");
                                    defaultTableModel.addColumn("Cnp");

                                    for (Employee employee : result) {
                                        defaultTableModel.addRow(new Object[]{
                                                employee.getName(),
                                                employee.getCnp() });
                                    }

                                    resultTable.setModel(defaultTableModel);
                                }
                            });

                        } catch (ExecutionException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                stringSwingWorker.execute();
            }
        });

        allVolunteers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Volunteer>, String> stringSwingWorker = new SwingWorker<List<Volunteer>, String>() {
                    @Override
                    protected List<Volunteer> doInBackground() throws Exception {

                        VolunteerService volunteerService = new VolunteerService();
                        return volunteerService.getVolunteers();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Volunteer> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Name");
                                    defaultTableModel.addColumn("Cnp");
                                    defaultTableModel.addColumn("Origin Country");

                                    for (Volunteer volunteer : result) {
                                        defaultTableModel.addRow(new Object[]{
                                                volunteer.getName(),
                                                volunteer.getCnp(),
                                                volunteer.getOriginCountry()
                                        });
                                    }

                                    resultTable.setModel(defaultTableModel);
                                }
                            });

                        } catch (ExecutionException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                stringSwingWorker.execute();
            }
        });

        allGuests.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Guest>, String> stringSwingWorker = new SwingWorker<List<Guest>, String>() {
                    @Override
                    protected List<Guest> doInBackground() throws Exception {

                        GuestService guestService = new GuestService();
                        return guestService.getGuests();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Guest> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Name");
                                    defaultTableModel.addColumn("Cnp");
                                    defaultTableModel.addColumn("Origin Country");

                                    for (Guest guest : result) {
                                        defaultTableModel.addRow(new Object[]{
                                                guest.getName(),
                                                guest.getCnp(),
                                                guest.getOriginCountry()
                                        });
                                    }

                                    resultTable.setModel(defaultTableModel);
                                }
                            });

                        } catch (ExecutionException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                stringSwingWorker.execute();
            }
        });

        searchGuestByCnp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Guest>, String> stringSwingWorker = new SwingWorker<List<Guest>, String>() {
                    @Override
                    protected List<Guest> doInBackground() throws Exception {

                        GuestService guestService = new GuestService();
                        return guestService.searchGuestsByCnp();

                    }

                    @Override
                    protected void done() {

                        try {
                            List<Guest> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Name");
                                    defaultTableModel.addColumn("Cnp");
                                    defaultTableModel.addColumn("Origin Country");

                                    for (Guest guest : result) {
                                        defaultTableModel.addRow(new Object[]{
                                                guest.getName(),
                                                guest.getCnp(),
                                                guest.getOriginCountry(),
                                        });
                                    }

                                    resultTable.setModel(defaultTableModel);
                                }
                            });

                        } catch (ExecutionException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                stringSwingWorker.execute();
            }
        });

        searchGuestByOriginCountry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Guest>, String> stringSwingWorker = new SwingWorker<List<Guest>, String>() {
                    @Override
                    protected List<Guest> doInBackground() throws Exception {

                        GuestService guestService = new GuestService();
                        return guestService.searchGuestsByCountry();

                    }

                    @Override
                    protected void done() {

                        try {
                            List<Guest> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Name");
                                    defaultTableModel.addColumn("Cnp");
                                    defaultTableModel.addColumn("Origin Country");

                                    for (Guest guest : result) {
                                        defaultTableModel.addRow(new Object[]{
                                                guest.getName(),
                                                guest.getCnp(),
                                                guest.getOriginCountry(),
                                        });
                                    }

                                    resultTable.setModel(defaultTableModel);
                                }
                            });

                        } catch (ExecutionException | InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                stringSwingWorker.execute();
            }
        });


    }

    public void initGUI() {
        JFrame jFrame = new JFrame("Hotel Service");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setPreferredSize(new Dimension(800, 600));
        jFrame.setContentPane(this.mainPanel);
        // make the jFrame visible
        jFrame.pack();
        jFrame.setVisible(true);

    }

    public static void main(String args[]) {
        HotelForm hotelForm = new HotelForm();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                hotelForm.initGUI();
            }
        });

    }

    private void createUIComponents() {
    }
}
