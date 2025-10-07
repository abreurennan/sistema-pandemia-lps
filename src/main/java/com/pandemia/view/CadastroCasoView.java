package com.pandemia.view;

import com.pandemia.model.Caso;
import com.pandemia.controller.CasoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroCasoView extends JFrame {
    
    private JTextField txtMorador;
    private JComboBox<String> cmbSituacao;
    private JTextField txtData;
    private JButton btnSalvar;
    private JButton btnLimpar;
    
    public CadastroCasoView() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Cadastro de Casos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        
        panel.add(new JLabel("Morador:"));
        txtMorador = new JTextField();
        panel.add(txtMorador);
        
        panel.add(new JLabel("Situacao:"));
        cmbSituacao = new JComboBox<>(new String[]{"Suspeito", "Confirmado", "Recuperado"});
        panel.add(cmbSituacao);
        
        panel.add(new JLabel("Data:"));
        txtData = new JTextField();
        panel.add(txtData);
        
        btnSalvar = new JButton("Salvar");
        btnLimpar = new JButton("Limpar");
        JButton btnVoltar = new JButton("Voltar");
        
        panel.add(btnSalvar);
        panel.add(btnLimpar);
        panel.add(btnVoltar);
        panel.add(new JLabel()); // espaço vazio
        
        add(panel);
        
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarCaso();
            }
        });
        
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void salvarCaso() {
        // Criar objeto Caso
        Caso caso = new Caso();
        caso.setMorador(txtMorador.getText());
        caso.setSituacao((String) cmbSituacao.getSelectedItem());
        caso.setData(txtData.getText());
        
        // Chamar Controller (Padrão MVC)
        CasoController controller = new CasoController();
        boolean sucesso = controller.salvar(caso);
        
        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Caso salvo!");
            limparCampos();
        }
    }
    
    private void limparCampos() {
        txtMorador.setText("");
        cmbSituacao.setSelectedIndex(0);
        txtData.setText("");
    }
    
    public static void main(String[] args) {
        new CadastroCasoView().setVisible(true);
    }
}