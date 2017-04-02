package br.com.oxi.laicnanifnalpym.utils.enums;

public enum Message {

    NAO_EXISTEM_DADOS_PARA_SEREM_EXIBIDOS("Não existem dados para serem exibidos"),
    USER_ALREADY("Usuário já existe! Tente com outro email!"),
    USER_NOT_FOUND("Email ou Senha estão errados, favor tentar novamente!"),
    SAVE_SUCCESS("Categoria cadastrada com Sucesso!"),
    UPDATE_SUCCESS("Categoria atualizada com Sucesso!"),
    MAX_UPLOAD_EXCEEDED("Tamanho de arquivo não é suportado! Escolha uma menor."),
    PICTURE_NOT_SELECTED("Favor selecione uma imagem!"),
    RECIPE_UPDATE("Recita atualizada com Sucesso!"),
    RECIPE_ACTUALIZE("Recita efetivada com Sucesso!"),
    RECIPE_ACTUALIZE_ERROR("Erro ao tentar efetivar recieta!"),
    RECIPE_CREATE("Recita cadastrada com Sucesso!"),
    RECIPE_TYPE_UPDATE("Tipo de Recita atualizada com Sucesso!"),
    RECIPE_TYPE_CREATE("Tipo de Recita cadastrada com Sucesso!"),
    RECIPE_TYPE_ALREADY("Tipo de Recita já existe!"),
    ACCOUNT_UPDATE("Conta atualizada com Sucesso!"),
    ACCOUNT_CREATE("Conta cadastrada com Sucesso!"), 
    ACCOUNT_ALREADY("Essa conta já existe!"), 
    ACCOUNT_CREATE_ERROR("Erro ao salvar! "),
    RECIPE_HAS_DELETED("A Recita foi deletada com sucesso!"),
    RECIPE_DELETE_ERROR("Erro ao deletar Receita!"), 
    RECIPE_CREATE_ERROR("Erro ao salvar Receita!");

    private String value;

    Message(String value) {
        this.value = value;
    }

    public String toString() {

        return this.value;
    }
}
