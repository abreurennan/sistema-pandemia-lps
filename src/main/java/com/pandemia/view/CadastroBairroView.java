package com.pandemia.view;

import com.pandemia.model.Bairro;
import com.pandemia.controller.BairroController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroBairroView extends JFrame {
    
    private JTextField txtNome;
    private JTextField txtCidade;
    private JTextField txtEstado;
    private JButton btnSalvar;
    private JButton btnLimpar;
    
    public CadastroBairroView() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Cadastro de Bairros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        
        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);
        
        panel.add(new JLabel("Cidade:"));
        txtCidade = new JTextField();
        panel.add(txtCidade);
        
        panel.add(new JLabel("Estado:"));
        txtEstado = new JTextField();
        panel.add(txtEstado);
        
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
                salvarBairro();
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
    
    private void salvarBairro() {
        // Criar objeto Bairro
        Bairro bairro = new Bairro();
        bairro.setNome(txtNome.getText());
        bairro.setCidade(txtCidade.getText());
        bairro.setEstado(txtEstado.getText());
        
        // Chamar Controller (Padrão MVC)
        BairroController controller = new BairroController();
        boolean sucesso = controller.salvar(bairro);
        
        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Bairro salvo!");
            limparCampos();
        }
    }
    
    private void limparCampos() {
        txtNome.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
    }
    
    public static void main(String[] args) {
        new CadastroBairroView().setVisible(true);
    }
}