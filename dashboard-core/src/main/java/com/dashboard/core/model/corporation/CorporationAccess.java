package com.dashboard.core.model.corporation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author LEBOC Philippe
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "corporation_access")
public class CorporationAccess {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private CorporationAccess corporationAccess;
}
