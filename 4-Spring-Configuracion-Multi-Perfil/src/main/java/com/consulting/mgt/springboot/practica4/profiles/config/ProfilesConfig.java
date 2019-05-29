package com.consulting.mgt.springboot.practica4.profiles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.consulting.mgt.springboot.practica4.profiles.bean.api.DummyDataSource;
import com.consulting.mgt.springboot.practica4.profiles.customprofiles.ProductionProfile;
import com.consulting.mgt.springboot.practica4.profiles.customprofiles.StagingProfile;

// clase de configuracion
public class ProfilesConfig {

	// define bean DummyDataSource para perfil dev

	// define bean DummyDataSource para perfil qa

	// define bean DummyDataSource para perfil staging con meta-anotacion

	// define bean DummyDataSource para perfil production con meta-anotacion
}
