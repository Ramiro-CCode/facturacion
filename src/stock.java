import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class stock {
    private JButton facturarButton;
    private JButton proveedoresButton;
    private JButton clientesButton;
    private JButton stockButton;
    private JFrame stockFrame;
    private JPanel vistastock;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField7;
    private JButton eliminarButton;
    private JButton agregarButton;
    private JTable stocktable;
    DefaultTableModel dtm=new DefaultTableModel();
    java.sql.Date fecha=new java.sql.Date(Calendar.getInstance().getTime().getTime());


    public void setVisible(boolean b) {
        stockFrame = new JFrame("Stock");
        stockFrame.setContentPane(vistastock);
        stockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stockFrame.pack();
        stockFrame.setVisible(b);
    }

    stock() {
        facturarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                facturacion frame = new facturacion();
                frame.setVisible(true);
                stockFrame.dispose();
            }
        });
        clientesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientes frame = new clientes();
                frame.setVisible(true);
                stockFrame.dispose();
            }
        });
        proveedoresButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                proveedores frame = new proveedores();
                frame.setVisible(true);
                stockFrame.dispose();
            }
        });

        dtm.addColumn("Fecha");
        dtm.addColumn("Codigo de producto");
        dtm.addColumn("Descripcion");
        dtm.addColumn("Cantidad");
        dtm.addColumn("Precio unitario");
        dtm.addColumn("Notas");
        stocktable.setModel(dtm);
        dtm.addRow(new Object[]{"Fecha","Código","Descripción","Cantidad","Precio unitario","Notas"});

        textField1.setText(String.valueOf(fecha));

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dtm.addRow(new Object[]{textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),textField7.getText()});
                stocktable.setModel(dtm);
                textField1.setText(String.valueOf(fecha));
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField7.setText("");
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = stocktable.getSelectedRow();
                dtm.removeRow(fila);
            }
        });
    }
}
