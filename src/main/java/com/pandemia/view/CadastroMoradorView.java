package com.pandemia.view;

import com.pandemia.model.Morador;
import com.pandemia.controller.MoradorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroMoradorView extends JFrame {
    
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtTelefone;
    private JButton btnSalvar;
    private JButton btnLimpar;
    
    public CadastroMoradorView() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Cadastro de Moradores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        
        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);
        
        panel.add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        panel.add(txtCpf);
        
        panel.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        panel.add(txtTelefone);
        
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
                salvarMorador();
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
    
    private void salvarMorador() {
        // Criar objeto Morador
        Morador morador = new Morador();
        morador.setNome(txtNome.getText());
        morador.setCpf(txtCpf.getText());
        morador.setTelefone(txtTelefone.getText());
        
        // Chamar Controller (Padrão MVC)
        MoradorController controller = new MoradorController();
        boolean sucesso = controller.salvar(morador);
        
        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Morador salvo!");
            limparCampos();
        }
    }
    
    private void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
    }
    
    public static void main(String[] args) {
        new CadastroMoradorView().setVisible(true);
    }
}