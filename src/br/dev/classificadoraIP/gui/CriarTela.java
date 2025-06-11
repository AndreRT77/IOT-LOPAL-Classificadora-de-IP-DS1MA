

package br.dev.classificadoraIP.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.dev.classificadoraIP.model.Classificadora;

public class CriarTela {

    private JLabel labelIP;
    private JLabel labelCIDR;
    private JLabel labelErro;
    private JTextField textOct1;
    private JLabel labelponto1;
    private JTextField textOct2;
    private JLabel labelponto2;
    private JTextField textOct3;
    private JLabel labelponto3;
    private JTextField textOct4;
    private JLabel labelbarra;
    private JTextField textCIDR;
    private JButton buttonCalcular;
    private JButton buttonApagar;
    private JTextArea areaResultado;
    private JLabel labelClasse;
    private JLabel labelMascaraBin;
    private JLabel labelMascaraDec;
    private JLabel labelIpsPorSubrede;
    private JLabel labelQtdSubredes;
    private JScrollPane scrollResultado;

    public void criarTela() {
        JFrame tela = new JFrame();
        tela.setTitle("Classificadora de IP");
        tela.setSize(620, 700);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLayout(null);
        tela.setLocationRelativeTo(null);

        Container container = tela.getContentPane();

        Font fonteTitulo = new Font("Segoe UI", Font.BOLD, 20);
        Font fontePadrao = new Font("Segoe UI", Font.PLAIN, 16);
        Font fonteResultado = new Font("Monospaced", Font.PLAIN, 14);
        Font fonteErro = new Font("Segoe UI", Font.BOLD, 14);

        labelIP = new JLabel("DIGITE O IP:");
        labelIP.setFont(fonteTitulo);
        labelIP.setBounds(30, 20, 200, 30);

        textOct1 = new JTextField(); 
        textOct1.setBounds(30, 60, 50, 35);
        labelponto1 = new JLabel(); 
		labelponto1.setText(".");
        labelponto1.setBounds(80, 60, 50, 35);
		labelponto1.setFont(new Font("Arial", Font.PLAIN, 30));

        textOct2 = new JTextField(); 
        textOct2.setBounds(90, 60, 50, 35);
        labelponto2 = new JLabel(); 
		labelponto2.setText(".");
        labelponto2.setBounds(140, 60, 50, 35);
		labelponto2.setFont(new Font("Arial", Font.PLAIN, 30));
		
        textOct3 = new JTextField(); 
        textOct3.setBounds(150, 60, 50, 35);
        labelponto3 = new JLabel(); 
		labelponto3.setText(".");
        labelponto3.setBounds(200, 60, 50, 35);
		labelponto3.setFont(new Font("Arial", Font.PLAIN, 30));
		
        textOct4 = new JTextField(); 
        textOct4.setBounds(210, 60, 50, 35);
        
        labelbarra = new JLabel();
		labelbarra.setText("/");
		labelbarra.setBounds(270, 60, 20, 40);
		labelbarra.setFont(new Font("Arial", Font.PLAIN, 30));

        labelCIDR = new JLabel("DIGITE O CIDR AQUI:");
        labelCIDR.setFont(fonteTitulo);
        labelCIDR.setBounds(300, 20, 250, 30);

        textCIDR = new JTextField(); textCIDR.setBounds(300, 60, 50, 35);

        buttonCalcular = new JButton("Classificar");
        buttonCalcular.setBounds(30, 110, 150, 30);
        buttonCalcular.setBackground(Color.green);
        buttonCalcular.setContentAreaFilled(false);
        buttonCalcular.setOpaque(true);
        buttonCalcular.setBackground(Color.green);
        buttonCalcular.setFont(fontePadrao);

        buttonApagar = new JButton("Limpar");
        buttonApagar.setBounds(200, 110, 150, 30);
        buttonApagar.setBackground(Color.RED);
        buttonApagar.setContentAreaFilled(false);
        buttonApagar.setOpaque(true);
        buttonApagar.setBackground(Color.RED);
        buttonApagar.setFont(fontePadrao);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(fonteResultado);
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);
        
        labelClasse = new JLabel("IP Classe: ");
        labelClasse.setFont(fontePadrao);
        labelClasse.setBounds(30, 160, 540, 25);

        labelMascaraBin = new JLabel("Máscara Binária: ");
        labelMascaraBin.setFont(fontePadrao);
        labelMascaraBin.setBounds(30, 190, 540, 25);

        labelMascaraDec = new JLabel("Máscara Decimal: ");
        labelMascaraDec.setFont(fontePadrao);
        labelMascaraDec.setBounds(30, 220, 540, 25);

        labelIpsPorSubrede = new JLabel("IPs por sub-rede: ");
        labelIpsPorSubrede.setFont(fontePadrao);
        labelIpsPorSubrede.setBounds(30, 250, 540, 25);

        labelQtdSubredes = new JLabel("Quantidade de sub-redes: ");
        labelQtdSubredes.setFont(fontePadrao);
        labelQtdSubredes.setBounds(30, 280, 540, 25);


        scrollResultado = new JScrollPane(areaResultado);
        scrollResultado.setBounds(30, 310, 540, 290);

        labelErro = new JLabel("Erro! Utilize apenas números válidos.");
        labelErro.setForeground(new Color(220, 20, 60));
        labelErro.setFont(fonteErro);
        labelErro.setBounds(30, 620, 540, 25);
        labelErro.setVisible(false);

        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    labelErro.setVisible(false);

                    String oct1 = textOct1.getText().trim();
                    String oct2 = textOct2.getText().trim();
                    String oct3 = textOct3.getText().trim();
                    String oct4 = textOct4.getText().trim();
                    String cidrStr = textCIDR.getText().trim();

                    int cidr = Integer.parseInt(cidrStr);

                    if (oct1.equals("00") || oct2.equals("00") || oct3.equals("00") || oct4.equals("00") ||
                        oct1.equals("000") || oct2.equals("000") || oct3.equals("000") || oct4.equals("000") ||
                        cidr <= 0 || cidr > 32) {
                        throw new IllegalArgumentException("Erro geral");
                    }

                    Classificadora ip = new Classificadora();
                    ip.setPrimeiroOcteto(oct1);
                    ip.setSegundoOcteto(oct2);
                    ip.setTerceiroOcteto(oct3);
                    ip.setQuartoOcteto(oct4);
                    ip.setCidr(cidr);
                    ip.setIp(oct1 + "." + oct2 + "." + oct3 + "." + oct4);
                    ip.mostrarDados();
                    
                    String mascaraBin = ip.getMascaraBinaria();
                    String mascaraBinFormatada = mascaraBin.replaceAll("(.{8})(?=.)", "$1.");

                    labelClasse.setText("IP Classe: " + ip.getIpClasse());
                    labelMascaraBin.setText("Máscara Binária: " + mascaraBinFormatada);
                    labelMascaraDec.setText("Máscara Decimal: " + ip.getMascaraDecimal());
                    labelIpsPorSubrede.setText("IPs por sub-rede: " + ip.getSubClasse());
                    labelQtdSubredes.setText("Quantidade de sub-redes: " + ip.getSubRedes());

                    StringBuilder subRedesTexto = new StringBuilder();
                    for (String linha : ip.listarSubRedes()) {
                        subRedesTexto.append(linha).append("\n");
                    }
                    areaResultado.setText(subRedesTexto.toString());

                } catch (Exception ex) {
                    areaResultado.setText("");
                    labelErro.setVisible(true);
                    labelErro.setText(" Erro! valores inválidos nos campos.");
                }
            }
        });

        buttonApagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textOct1.setText("");
                textOct2.setText("");
                textOct3.setText("");
                textOct4.setText("");
                textCIDR.setText("");
                areaResultado.setText("");
                labelErro.setVisible(false);
                labelClasse.setText("IP Classe: ");
                labelMascaraBin.setText("Máscara Binária: ");
                labelMascaraDec.setText("Máscara Decimal: ");
                labelIpsPorSubrede.setText("IPs por sub-rede: ");
                labelQtdSubredes.setText("Quantidade de sub-redes: ");

            }
        });

        container.add(labelIP);
        container.add(textOct1);
        container.add(labelponto1);
        container.add(textOct2);
        container.add(labelponto2);
        container.add(textOct3);
        container.add(labelponto3);
        container.add(textOct4);
        container.add(labelbarra);
        container.add(labelCIDR);
        container.add(textCIDR);
        container.add(buttonCalcular);
        container.add(buttonApagar);
        container.add(scrollResultado);
        container.add(labelErro);
        container.add(labelClasse);
        container.add(labelMascaraBin);
        container.add(labelMascaraDec);
        container.add(labelIpsPorSubrede);
        container.add(labelQtdSubredes);


        tela.setVisible(true);
    }
}
