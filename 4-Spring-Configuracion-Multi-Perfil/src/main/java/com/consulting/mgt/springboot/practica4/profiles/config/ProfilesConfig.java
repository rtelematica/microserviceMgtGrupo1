package com.consulting.mgt.springboot.practica4.profiles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.consulting.mgt.springboot.practica4.profiles.bean.api.DummyDataSource;
import com.consulting.mgt.springboot.practica4.profiles.customprofiles.Production;
import com.consulting.mgt.springboot.practica4.profiles.customprofiles.Staging;

// clase de configuracion
@Configuration
public class ProfilesConfig {

	// define bean DummyDataSource para perfil dev
	@Bean
	@Profile("dev")
	public DummyDataSource devDataSource() {
		return new DummyDataSource() {

			@Override
			public void connect() {
				System.out.println("connected to dev DataSource");
			}
		};
	}

	// define bean DummyDataSource para perfil qa
	@Bean
	@Profile("qa")
	public DummyDataSource qaDataSource() {
		return new DummyDataSource() {

			@Override
			public void connect() {
				System.out.println("connected to qa DataSource");
			}
		};
	}

	// define bean DummyDataSource para perfil staging con meta-anotacion
	@Bean
	@Staging
	public DummyDataSource stagingDataSource() {
		return new DummyDataSource() {

			@Override
			public void connect() {
				System.out.println("connected to staging DataSource");
			}
		};
	}

	// define bean DummyDataSource para perfil production con meta-anotacion
	@Bean
	@Production
	public DummyDataSource prodDataSource() {
		return new DummyDataSource() {

			@Override
			public void connect() {
				System.out.println("connected to prod DataSource");
			}
		};
	}
}
