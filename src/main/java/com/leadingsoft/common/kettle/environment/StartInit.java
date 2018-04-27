package com.leadingsoft.common.kettle.environment;

import org.springframework.beans.factory.InitializingBean;

public class StartInit implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		//初始化环境***
		com.leadingsoft.common.kettle.environment.KettleInit.init();
		org.pentaho.di.core.KettleEnvironment.init();
	}

}
