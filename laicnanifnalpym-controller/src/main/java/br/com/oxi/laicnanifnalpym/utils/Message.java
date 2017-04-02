package br.com.oxi.laicnanifnalpym.utils;

public enum Message {

    NAO_EXISTEM_DADOS_PARA_SEREM_EXIBIDOS("Não existem dados para serem exibidos"),
    CATEGORIA_JA_EXISTENTE("Categoria já existe"),
    SAVE_SUCCESS("Categoria cadastrada com Sucesso!"),
    UPDATE_SUCCESS("Categoria atualizada com Sucesso!"),
    MAX_UPLOAD_EXCEEDED("Tamanho de arquivo não é suportado! Escolha uma menor."),
    PICTURE_NOT_SELECTED("Favor selecione uma imagem!");

    private String value;

    Message(String value) {
        this.value = value;
    }

    public String toString() {

        return this.value;
    }
}
