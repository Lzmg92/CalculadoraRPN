package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;

/**
 * Created by Leslie on 15/04/2014.
 */
public class Log_201314808 extends JFrame {

    JFrame ventanalog = new JFrame("Log");

    DefaultTableModel registros = new DefaultTableModel();
    JTable registro = new JTable(registros);
    JScrollPane scroll = new JScrollPane(registro);


    //Botones
    JButton guardar = new JButton("Guardar");
    JButton cancelar = new JButton("Cancelar");

    JLabel guardc = new JLabel("Guardar Como:");
    JTextField name = new JTextField();

    //fondo
    ImageIcon ic = new javax.swing.ImageIcon(getClass().getResource("fond.jpg"));
    Image ima = ic.getImage();
    ImageIcon ico = new ImageIcon(ima.getScaledInstance(460,360,Image.SCALE_SMOOTH));
    JLabel fon = new JLabel(ico);

    //listas
    LinkedList lista1 = new LinkedList();
    LinkedList lista2 = new LinkedList();
    LinkedList lista3 = new LinkedList();


    String temp, temp2, ruta;

    public void Escribir (String NombreArchivo){

        File f;
        f = new File(ruta, NombreArchivo);

        try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);

            wr.write("Operadores");
            wr.append("\t\t\tAcciones\t\t\t\t");
            wr.append("Pila");
            wr.write(System.lineSeparator());

            for(int i=0;i< registros.getRowCount();i++){
                wr.write(String.valueOf(lista1.get(i)));
                wr.append("\t\t\t"+String.valueOf(lista2.get(i))+"\t\t\t\t");
                wr.append(String.valueOf(lista3.get(i)));
                wr.write(System.lineSeparator());

            }

            wr.close();
            bw.close();

            JOptionPane.showMessageDialog(null, "El archivo "+temp2+".txt ha sido guardado en "+ruta);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "La ruta especificada no existe", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();}
    }


    public Log_201314808() {

        ventanalog.setSize(450, 280);
        ventanalog.setLocationRelativeTo(this);
        ventanalog.setResizable(false);

        registro.setPreferredScrollableViewportSize(new Dimension(400, 50));
        ventanalog.getContentPane().add(scroll,BorderLayout.CENTER);
        ventanalog.add(guardar);
        ventanalog.add(cancelar);
        ventanalog.add(scroll);
        ventanalog.add(guardc);
        ventanalog.add(name);
        ventanalog.add(fon);
        ventanalog.setLayout(null);

        registro.setLocation(15,10);
        registro.setSize(400, 200);
        scroll.setBounds(25,10, 400, 200);

        guardar.setBounds(240, 220, 90, 25);
        guardar.setBackground(Color.black);
        guardar.setForeground(Color.white);
        guardar.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        cancelar.setBounds(340, 220, 90, 25);
        cancelar.setBackground(Color.black);
        cancelar.setForeground(Color.white);
        cancelar.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        guardc.setBounds(10, 220, 90, 25);
        guardc.setForeground(Color.black);
        guardc.setFont(new Font("Arial Rounded", Font.BOLD, 11));

        name.setBounds(100,220,125,25);

        fon.setBounds(-5, -5, 460,360);
        ventanalog.setVisible(true);
        ventanalog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       ///////////////////Funciones
        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(name.getText().equals("")){
                    temp2 = "Sin titulo";
                }else{temp2 = name.getText(); }

                for(int i=0;i< registros.getRowCount();i++){
                lista1.add(registros.getValueAt(i,0));
                lista2.add(registros.getValueAt(i,1));
                lista3.add(registros.getValueAt(i,2));
                }
                ruta = JOptionPane.showInputDialog("Ingrese un Ubicacion: ");
                Escribir(temp2+".txt");

                name.setText("");

            }
        });

        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana_201314808 n = new ventana_201314808();
                ventanalog.setVisible(false);}});

    }

}
