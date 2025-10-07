package com.pandemia;

import com.pandemia.view.CadastroBairroView;
import com.pandemia.view.CadastroMoradorView;
import com.pandemia.view.CadastroCasoView;

import javax.swing.*;
import java.awt.*;

/**
 * Sistema de Informações da Pandemia
 * Trabalho Acadêmico - Padrão MVC + JPA/Hibernate
 * 
 * ENTREGA 1: Views dos Cadastros Básicos
 */
public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().criarMenuPrincipal());
    }
    
    /**
     * Cria menu principal simples para acessar os cadastros
     */
    private void criarMenuPrincipal() {
        JFrame frame = new JFrame("Sistema Pandemia - Cadastros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        // Título
        JLabel titulo = new JLabel("Sistema de Informações da Pandemia", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo);
        
        JLabel subtitulo = new JLabel("Cadastros - Entrega 1", JLabel.CENTER);
        subtitulo.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(subtitulo);
        
        // Botões dos cadastros
        JButton btnBairros = new JButton("Cadastro de Bairros");
        btnBairros.addActionListener(e -> new CadastroBairroView().setVisible(true));
        panel.add(btnBairros);
        
        JButton btnMoradores = new JButton("Cadastro de Moradores");
        btnMoradores.addActionListener(e -> new CadastroMoradorView().setVisible(true));
        panel.add(btnMoradores);
        
        JButton btnCasos = new JButton("Cadastro de Casos COVID-19");
        btnCasos.addActionListener(e -> new CadastroCasoView().setVisible(true));
        panel.add(btnCasos);
        
        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> System.exit(0));
        panel.add(btnSair);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}