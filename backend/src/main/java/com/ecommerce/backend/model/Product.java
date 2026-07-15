package com.ecommerce.backend.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "dummy_id", unique = true)
    private Integer dummyId;

    @Column(name = "sku", length = 50)
    private String sku;

    @Column(name = "titulo", length = 200, nullable = false)
    private String titulo;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "categoria", length = 50, nullable = false)
    private String categoria;

    @Column(name = "marca", length = 100)
    private String marca;

    @Column(name = "preco", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(name = "percentual_desconto", precision = 5, scale = 2)
    private BigDecimal percentualDesconto;

    @Column(name = "avaliacao", precision = 3, scale = 2)
    private BigDecimal avaliacao;

    @Column(name = "estoque", nullable = false)
    private Integer estoque;

    @Column(name = "peso", precision = 10, scale = 2)
    private BigDecimal peso;

    @Column(name = "largura", precision = 10, scale = 2)
    private BigDecimal largura;

    @Column(name = "altura", precision = 10, scale = 2)
    private BigDecimal altura;

    @Column(name = "profundidade", precision = 10, scale = 2)
    private BigDecimal profundidade;

    @Column(name = "informacoes_garantia")
    private String informacoesGarantia;

    @Column(name = "informacoes_envio")
    private String informacoesEnvio;

    @Column(name = "status_disponibilidade", length = 50)
    private String statusDisponibilidade;

    @Column(name = "politica_devolucao")
    private String politicaDevolucao;

    @Column(name = "quantidade_minima_pedido")
    private Integer quantidadeMinimaPedido;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "tags", columnDefinition = "text[]")
    private List<String> tags;

    @Column(name = "thumbnail_url", nullable = false, columnDefinition = "TEXT")
    private String thumbnailUrl;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> imagens;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao = LocalDateTime.now();
}
