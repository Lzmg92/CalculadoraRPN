package com.company;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Leslie on 13/04/2014.
 */
public class ventana_201314808 extends JFrame {
    JFrame ventana = new JFrame("Calculadora RPN");
    // campos
    JTextField p1 = new JTextField();
    JTextField p2 = new JTextField();
    JTextField p3 = new JTextField();
    //botones numeros
    JButton b0 = new JButton("0");
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    //botones funciones regulares
    JButton bmasme = new JButton("+/-");
    JButton bpunto = new JButton(".");
    JButton benter = new JButton("Enter");
    JButton bpor = new JButton("*");
    JButton bdiv = new JButton("/");
    JButton bmas = new JButton("+");
    JButton bmenos = new JButton("-");
    JButton braiz = new JButton("sqrt()");
    JButton braizx = new JButton("raizx");
    JButton bcuadrado = new JButton("x^2");
    JButton bpotencia = new JButton("x^y");
    JButton blog = new JButton("Log");
    //botonoes trigonométricas
    JButton bcoseno = new JButton("Cos()");
    JButton bseno = new JButton("Sen()");
    JButton btangente = new JButton("Tan()");
    JButton bCLS = new JButton("CLR");
    JButton bdelete = new JButton("DEL");

    //fondo
    ImageIcon ic = new javax.swing.ImageIcon(getClass().getResource("fond.jpg"));
    Image ima = ic.getImage();
    ImageIcon ico = new ImageIcon(ima.getScaledInstance(460,360,Image.SCALE_SMOOTH));
    JLabel fon = new JLabel(ico);

    String acumulador = "";

    Stack <Double> pila = new Stack<Double>();
    LinkedList<String> lista1 = new LinkedList<String>();
    LinkedList<String> lista2 = new LinkedList<String>();
    LinkedList<String> lista3 = new LinkedList<String>();


    double resr;
    double drad = Math.PI / 180;

    double getnum;

    public ventana_201314808() {



        ventana.setSize(450, 280);
        ventana.setLocationRelativeTo(this);
        ventana.setResizable(false);


        ventana.add(p1);
        ventana.add(p2);
        ventana.add(p3);

        ventana.add(b0);
        ventana.add(b1);
        ventana.add(b2);
        ventana.add(b3);
        ventana.add(b4);
        ventana.add(b5);
        ventana.add(b6);
        ventana.add(b7);
        ventana.add(b8);
        ventana.add(b9);

        ventana.add(bmasme);
        ventana.add(bpunto);
        ventana.add(benter);
        ventana.add(bpor);
        ventana.add(bdiv);
        ventana.add(bmas);
        ventana.add(bmenos);
        ventana.add(braiz);
        ventana.add(braizx);
        ventana.add(bcuadrado);
        ventana.add(bpotencia);
        ventana.add(blog);

        ventana.add(bcoseno);
        ventana.add(bseno);
        ventana.add(btangente);
        ventana.add(bCLS);
        ventana.add(bdelete);

        ventana.add(fon);

        ventana.setLayout(null);

        p1.setBounds(25, 5, 400, 25);
        p2.setBounds(25, 35, 400, 25);
        p3.setBounds(25, 65, 400, 25);
//columna 1
        b7.setBounds(25, 95, 65, 25);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        b4.setBounds(25, 125, 65, 25);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        b1.setBounds(25, 155, 65, 25);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        bmasme.setBounds(25, 185, 65, 25);
        bmasme.setBackground(Color.black);
        bmasme.setForeground(Color.white);
        bmasme.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        benter.setBounds(25, 215, 200, 25);
        benter.setBackground(Color.black);
        benter.setForeground(Color.white);
        benter.setFont(new Font("Arial Rounded", Font.BOLD, 12));
//columna 2
        b8.setBounds(93, 95, 65, 25);
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        b5.setBounds(93, 125, 65, 25);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        b2.setBounds(93, 155, 65, 25);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        b0.setBounds(93, 185, 65, 25);
        b0.setBackground(Color.black);
        b0.setForeground(Color.white);
        b0.setFont(new Font("Arial Rounded", Font.BOLD, 12));
//columna 3
        b9.setBounds(160, 95, 65, 25);
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        b9.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        b6.setBounds(160, 125, 65, 25);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        b3.setBounds(160, 155, 65, 25);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        bpunto.setBounds(160, 185, 65, 25);
        bpunto.setBackground(Color.black);
        bpunto.setForeground(Color.white);
        bpunto.setFont(new Font("Arial Rounded", Font.BOLD, 12));
//columna 4
        bpor.setBounds(227, 95, 65, 25);
        bpor.setBackground(Color.black);
        bpor.setForeground(Color.white);
        bpor.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        bmas.setBounds(227, 125, 65, 25);
        bmas.setBackground(Color.black);
        bmas.setForeground(Color.white);
        bmas.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        braiz.setBounds(227, 155, 65, 25);
        braiz.setBackground(Color.black);
        braiz.setForeground(Color.white);
        braiz.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        bcuadrado.setBounds(227, 185, 65, 25);
        bcuadrado.setBackground(Color.black);
        bcuadrado.setForeground(Color.white);
        bcuadrado.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        blog.setBounds(227, 215, 132, 25);
        blog.setBackground(Color.black);
        blog.setForeground(Color.white);
        blog.setFont(new Font("Arial Rounded", Font.BOLD, 12));

//columna 5
        bdiv.setBounds(294, 95, 65, 25);
        bdiv.setBackground(Color.black);
        bdiv.setForeground(Color.white);
        bdiv.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        bmenos.setBounds(294, 125, 65, 25);
        bmenos.setBackground(Color.black);
        bmenos.setForeground(Color.white);
        bmenos.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        braizx.setBounds(294, 155, 65, 25);
        braizx.setBackground(Color.black);
        braizx.setForeground(Color.white);
        braizx.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        bpotencia.setBounds(294, 185, 65, 25);
        bpotencia.setBackground(Color.black);
        bpotencia.setForeground(Color.white);
        bpotencia.setFont(new Font("Arial Rounded", Font.BOLD, 12));

//columna 6
        bcoseno.setBounds(360, 95, 65, 25);
        bcoseno.setBackground(Color.black);
        bcoseno.setForeground(Color.white);
        bcoseno.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        bseno.setBounds(360, 125, 65, 25);
        bseno.setBackground(Color.black);
        bseno.setForeground(Color.white);
        bseno.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        btangente.setBounds(360, 155, 65, 25);
        btangente.setBackground(Color.black);
        btangente.setForeground(Color.white);
        btangente.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        bCLS.setBounds(360, 185, 65, 25);
        bCLS.setBackground(Color.black);
        bCLS.setForeground(Color.white);
        bCLS.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        bdelete.setBounds(360, 215, 65, 25);
        bdelete.setBackground(Color.black);
        bdelete.setForeground(Color.white);
        bdelete.setFont(new Font("Arial Rounded", Font.BOLD, 12));

        fon.setBounds(-5, -5, 460, 360);

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Funciones de los botones para ingresar numeros

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador + "1";
                p3.setText(acumulador);
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador + "2";
                p3.setText(acumulador);
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador + "3";
                p3.setText(acumulador);
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador + "4";
                p3.setText(acumulador);
            }
        });

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador + "5";
                p3.setText(acumulador);
            }
        });

        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador + "6";
                p3.setText(acumulador);
            }
        });

        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador + "7";
                p3.setText(acumulador);
            }
        });

        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador + "8";
                p3.setText(acumulador);
            }
        });

        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador + "9";
                p3.setText(acumulador);
            }
        });

        b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador + "0";
                p3.setText(acumulador);
            }
        });

//////////////// Funcion para punto
        bpunto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador + ".";
                p3.setText(acumulador);
            }
        });

////////////// Funcion mas menos
        bmasme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double opnum = Double.parseDouble(p3.getText());
                if (opnum > 0) opnum = 0.0 - opnum;
                else if (opnum < 0) Math.abs(opnum);
                acumulador = String.valueOf(opnum);
                p3.setText(acumulador);
            }
        });
        ////////////// Funcion para clear
        bCLS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (pila.empty() == false) {
                    pila.pop();
                }
                p3.setText("");
                p1.setText("");
                p2.setText("");
                acumulador = "";
            }
        });

////////////// Funcion para delete
        bdelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acumulador = acumulador.substring(0, acumulador.length() - 1);
                p3.setText(acumulador);
            }
        });


////////////// Funcion enter
        benter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getnum = Double.parseDouble(p3.getText());
                String numlist = String.valueOf(getnum);
                lista1.add(numlist);
                lista2.add("PUSH");
                pila.push(getnum);
                lista3.add(String.valueOf(pila));
                acumulador = "";
                p1.setText(p2.getText());
                p2.setText(p3.getText());
                p3.setText("");
                acumulador = "";


            }
        });

////////////////// Funcion para multiplicar
        bpor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double op1 = pila.pop();
                double op2 = pila.pop();
                double op3;
                if (pila.empty() == false) {
                    op3 = pila.peek();
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                } else {
                    op3 = 0.0;
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                }

                double res = op1 * op2;
                pila.push(res);
                lista1.add("*");
                lista2.add("MULTIP");
                lista3.add(String.valueOf(pila));
                acumulador = String.valueOf(res);

                p2.setText(acumulador);
                p3.setText("");
                acumulador = "";
            }
        });

        ////////////////// Funcion para dividir
        bdiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double op2 = pila.pop();
                double op1 = pila.pop();
                double op3;

                if (pila.empty() == false) {
                    op3 = pila.peek();
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                } else {
                    op3 = 0.0;
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                }

                if(op2==0){
                    JOptionPane.showMessageDialog(ventana, "No es posible dividir por 0", "Error", JOptionPane.ERROR_MESSAGE);
                } else{
                double res = Math.rint(op1 / op2*10000)/10000;

                pila.push(res);
                lista1.add("/");
                lista2.add("DIVI");
                lista3.add(String.valueOf(pila));
                acumulador = String.valueOf(res);

                p2.setText(acumulador);}
                p3.setText("");
                acumulador = "";
            }
        });

////////////////// Funcion para sumar
        bmas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double op1 = pila.pop();
                double op2 = pila.pop();
                double op3;
                if (pila.empty() == false) {
                    op3 = pila.peek();
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                } else {
                    op3 = 0.0;
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                }
                double res = op1 + op2;
                pila.push(res);
                lista1.add("+");
                lista2.add("SUMA");
                lista3.add(String.valueOf(pila));
                acumulador = String.valueOf(res);

                p2.setText(acumulador);
                p3.setText("");
                acumulador = "";
            }
        });

////////////////// Funcion para restar
        bmenos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double op1 = pila.pop();
                double op2 = pila.pop();
                double op3;
                if (pila.empty() == false) {
                    op3 = pila.peek();
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                } else {
                    op3 = 0.0;
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                }
                double res = op2 - op1;
                pila.push(res);
                lista1.add("-");
                lista2.add("REST");
                lista3.add(String.valueOf(pila));
                acumulador = String.valueOf(res);
                p2.setText(acumulador);
                p3.setText("");
                acumulador = "";
            }
        });

////////////////// Funcion para raiz cuadrada
        braiz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double op1 = pila.pop();
                double op3;
                if (pila.empty() == false) {
                    op3 = pila.peek();
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                } else {
                    op3 = 0.0;
                    String camp = String.valueOf(op3);
                    p1.setText(camp);}

                if (op1<0){
                    JOptionPane.showMessageDialog(ventana, "No se pueden operar raices negativas", "Error", JOptionPane.ERROR_MESSAGE);
                } else { resr = Math.rint(Math.sqrt(op1)*10000)/10000;}
                pila.push(resr);
                lista1.add("sqrt()");
                lista2.add("RAIZC");
                lista3.add(String.valueOf(pila));
                acumulador = String.valueOf(resr);
                p2.setText(acumulador);
                p3.setText("");
                acumulador = "";
                resr = 0.0;
            }
        });

////////////////// Funcion para raiz de x
        braizx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double op2 = pila.pop();
                double op1 = pila.pop();
                double op3;
                if (pila.empty() == false) {
                    op3 = pila.peek();
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                } else {
                    op3 = 0.0;
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                }
                if (op1<0){
                    JOptionPane.showMessageDialog(ventana, "No se pueden operar raices negativas", "Error", JOptionPane.ERROR_MESSAGE);
                    resr = 0.0;
                } else {resr = Math.rint(Math.pow(op1, 1/op2)*10000)/10000;}
                pila.push(resr);

                pila.push(resr);
                lista1.add("raizx");
                lista2.add("RAIZX");
                lista3.add(String.valueOf(pila));
                acumulador = String.valueOf(resr);

                p2.setText(acumulador);
                p3.setText("");
                acumulador = "";
            }
        });

////////////////// Funcion para elevar al cuadrado
        bcuadrado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double op1 = pila.pop();
                double op3;
                if (pila.empty() == false) {
                    op3 = pila.peek();
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                } else {
                    op3 = 0.0;
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                }
                double res = Math.pow(op1, 2);
                pila.push(res);
                lista1.add("X^2");
                lista2.add("CUADRADO");
                lista3.add(String.valueOf(pila));
                acumulador = String.valueOf(res);

                p2.setText(acumulador);
                p3.setText("");
                acumulador = "";
            }
        });

////////////////// Funcion para elevar a la x
        bpotencia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double op1 = pila.pop();
                double op2 = pila.pop();
                double op3;
                if (pila.empty() == false) {
                    op3 = pila.peek();
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                } else {
                    op3 = 0.0;
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                }

                double res = Math.pow(op1, op2);
                pila.push(res);
                lista1.add("X^Y");
                lista2.add("POTENCIA");
                lista3.add(String.valueOf(pila));
                acumulador = String.valueOf(res);

                p2.setText(acumulador);
                p3.setText("");
                acumulador = "";
            }
        });

////////////////// Funcion para seno
        bseno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double op1 = pila.pop();
                double op3;
                if (pila.empty() == false) {
                    op3 = pila.peek();
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                } else {
                    op3 = 0.0;
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                }
                double res =  Math.rint( Math.sin(op1)*10000)/10000;
                pila.push(res);
                lista1.add("Sin()");
                lista2.add("SEN");
                lista3.add(String.valueOf(pila));
                acumulador = String.valueOf(res);

                p2.setText(acumulador);
                p3.setText("");
                acumulador = "";
            }
        });

////////////////// Funcion para coseno
        bcoseno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double op1 = pila.pop();
                double op3;
                if (pila.empty() == false) {
                    op3 = pila.peek();
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                } else {
                    op3 = 0.0;
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                }
                double res =  Math.rint( Math.cos(op1)*10000)/10000;
                pila.push(res);
                lista1.add("Cos()");
                lista2.add("COS");
                lista3.add(String.valueOf(pila));
                acumulador = String.valueOf(res);

                p2.setText(acumulador);
                p3.setText("");
                acumulador = "";
            }
        });

////////////////// Funcion para tangente
        btangente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double op1 = pila.pop();
                double op3;
                if (pila.empty() == false) {
                    op3 = pila.peek();
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                } else {
                    op3 = 0.0;
                    String camp = String.valueOf(op3);
                    p1.setText(camp);
                }
                double res =  Math.rint( Math.tan(op1)*10000)/10000;
                pila.push(res);
                lista1.add("Tan()");
                lista2.add("TAN");
                lista3.add(String.valueOf(pila));
                acumulador = String.valueOf(res);

                p2.setText(acumulador);
                p3.setText("");
                acumulador = "";
            }
        });



////////////////// Funcion para Log
        blog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Log_201314808 lo = new Log_201314808();

                String [] operadores = new String[lista1.size()];
                for(int i=0;i<lista1.size();i++){
                    operadores[i]= lista1.get(i);}
                lo.registros.addColumn("Ingresado",operadores);

                String [] operaciones = new String[lista1.size()];
                for(int i=0;i<lista2.size();i++){
                    operaciones[i]= lista2.get(i);}
                lo.registros.addColumn("Acciones",operaciones);

                String [] pila = new String[lista1.size()];
                for(int i=0;i<lista3.size();i++){
                    pila[i]= lista3.get(i);}
                lo.registros.addColumn("Pila",pila);


                ventana.setVisible(false);

                ;}});
    }
}
