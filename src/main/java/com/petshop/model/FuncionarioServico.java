package com.petshop.model;

import java.time.LocalDate;

public class FuncionarioServico {
    private Long idFunc;
    private Long idServ;
    private LocalDate dataAgendamento;

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

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
}
