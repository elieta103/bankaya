package com.elhg.pockemon.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habilidades {
	private GenericNameUrl ability;
	private boolean is_hidden;
	private int slot;
}
