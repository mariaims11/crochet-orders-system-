
CREATE TABLE categorias (
                            id_categoria SERIAL PRIMARY KEY,
                            nome VARCHAR(100) NOT NULL
);

CREATE TABLE produtos (
                          id_produto SERIAL PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          descricao TEXT,
                          preco DECIMAL(10,2),
                          stock INT,
                          personalizavel BOOLEAN,
                          criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          atualizado_em TIMESTAMP,
                          id_categoria INT,
                          FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

CREATE TABLE imagens_produto (
                                 id_imagem SERIAL PRIMARY KEY,
                                 imagem_url VARCHAR(255),
                                 tipo_imagem VARCHAR(50),
                                 id_produto INT,
                                 FOREIGN KEY (id_produto) REFERENCES produtos(id_produto)
);

CREATE TABLE cores (
                       id_cor SERIAL PRIMARY KEY,
                       nome_cor VARCHAR(50),
                       codigo_hex VARCHAR(7)
);

CREATE TABLE produto_cores (
                               id_produto INT,
                               id_cor INT,
                               PRIMARY KEY (id_produto, id_cor),
                               FOREIGN KEY (id_produto) REFERENCES produtos(id_produto),
                               FOREIGN KEY (id_cor) REFERENCES cores(id_cor)
);

CREATE TABLE clientes (
                          id_cliente SERIAL PRIMARY KEY,
                          nome VARCHAR(100),
                          email VARCHAR(100),
                          telefone VARCHAR(20),
                          morada TEXT,
                          criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE encomendas (
                            id_encomenda SERIAL PRIMARY KEY,
                            data_encomenda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            total DECIMAL(10,2),
                            estado VARCHAR(50) DEFAULT 'pendente',
                            estado_pagamento VARCHAR(50) DEFAULT 'pendente',
                            metodo_pagamento VARCHAR(50),
                            observacoes TEXT,
                            morada_entrega TEXT,
                            id_cliente INT,
                            FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE linhas_encomenda (
                                  id_linha SERIAL PRIMARY KEY,
                                  quantidade INT NOT NULL,
                                  preco DECIMAL(10,2) NOT NULL,
                                  id_encomenda INT,
                                  id_produto INT,
                                  FOREIGN KEY (id_encomenda) REFERENCES encomendas(id_encomenda),
                                  FOREIGN KEY (id_produto) REFERENCES produtos(id_produto)
);