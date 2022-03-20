package com.elhg.pockemon.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VersionDetails {
	private int rarity;
	private GenericNameUrl version;
}
