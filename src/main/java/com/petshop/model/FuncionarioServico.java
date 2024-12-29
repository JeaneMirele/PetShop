package com.petshop.model;

import java.time.LocalDateTime;

public class FuncionarioServico {
    private Long idFunc;
    private Long idServ;
    private LocalDateTime dataAgendamento;

    public Long getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Long idFunc) {
        this.idFunc = idFunc;
    }

    public Long getIdServ() {
        return idServ;
    }

    public void setIdServ(Long idServ) {
        this.idServ = idServ;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
}
