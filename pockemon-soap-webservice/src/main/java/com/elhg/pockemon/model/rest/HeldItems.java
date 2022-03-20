package com.elhg.pockemon.model.rest;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeldItems {
	private GenericNameUrl item;
	private VersionDetails[] version_details;
}
