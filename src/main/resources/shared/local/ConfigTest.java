package com.bbva.smre.lib.rf10.local;

import com.bbva.smre.lib.rf10.helpers.BbddOperationsAPX;
import com.bbva.smre.lib.rf10.helpers.ElasticHelper;
import com.bbva.smre.lib.rf10.helpers.InfraHelper;
import com.bbva.smre.lib.rf10.helpers.Validations;
import com.bbva.smre.lib.rf10.interfaces.IBbddOperations;
import com.bbva.smre.lib.rf10.interfaces.IElasticHelper;
import com.bbva.smre.lib.rf10.utils.Utils;
import com.bbva.smre.lib.rf10.values.SMRERF10Constants;

public class ConfigTest {
	
	private ConfigTest() {}
	
	public static IElasticHelper initElas(InfraHelper ih,Validations val) {
		if("LOCAL".equals(Utils.getStrProp(ih.getApplicationConfigurationService(), SMRERF10Constants.CAPX_RUN_MODE,SMRERF10Constants.CAPX_RUN_MODE_DV))) {
			return new ElasticSearchRepository();
		}
		return new ElasticHelper(ih,val);
		
	}
	public static IBbddOperations initOrac(InfraHelper ih) {
		if("LOCAL".equals(Utils.getStrProp(ih.getApplicationConfigurationService(), SMRERF10Constants.CAPX_RUN_MODE,SMRERF10Constants.CAPX_RUN_MODE_DV))) {
			return new OracleH2BBDD();		
		}
		return new BbddOperationsAPX(ih.getJdbcUtils());				
	}

}
