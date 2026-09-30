package com.bbva.smre.lib.rf10.impl.local;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.osgi.framework.Bundle;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.RequestHeaderParamsName;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.elara.test.osgi.DummyBundleContext;
import com.bbva.smre.lib.rf10.helpers.InfraHelper;
import com.bbva.smre.lib.rf10.helpers.LogerUtils;
import com.bbva.smre.lib.rf10.helpers.Validations;
import com.bbva.smre.lib.rf10.local.OracleH2BBDD;
import com.bbva.smre.lib.rf10.values.SMRERF10Constants;

import com.bbva.smre.lib.rf10.local.ConfigTest;
import com.bbva.smre.lib.rf10.local.ConstantsLoc;
import com.bbva.smre.lib.rf10.local.ElasticSearchRepository;
import com.bbva.smre.lib.rf10.local.EncriptadorAES;

import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.eq;

public class SMRERF10ImplTestLoc {
	
	
	public static final String CAPX_GCP_MASTER_PW_DV      = "2oficiosIA.By.BBVA.AYESA6";
	
	public static final String BP="/Users/Shared/DesBbvaGitHub/smre/smretf1001es";
	
	@Mock
	private DummyBundleContext bundleContext;
	@Mock
	private CommonRequestHeader commonRequestHeader;

	@Mock
	TransactionRequest transactionRequest;

	@Mock
	Context context;
	
	
	
	@Mock
	ApplicationConfigurationService applicationConfigurationService;
	
	@Mock
	OracleH2BBDD jdbcUtilsLocal;

	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		CommonRequestBody body = new CommonRequestBody();
		body.setTransactionParameters(new ArrayList<>());
		transactionRequest.setBody(body);
		transactionRequest.setHeader(commonRequestHeader);
		context.setTransactionRequest(transactionRequest);
		 context = new Context();
	        context.setTransactionRequest(this.setHeaders());
		ThreadContext.set(context);
		Bundle bundle = Mockito.mock(Bundle.class);
		Mockito.when(bundleContext.getBundle()).thenReturn(bundle);
	}
	
	 private TransactionRequest setHeaders() {
	        TransactionRequest tRequest = new TransactionRequest();
	        Map<RequestHeaderParamsName, Object> headerParamsMap = new EnumMap<>(RequestHeaderParamsName.class);

	        headerParamsMap.put(RequestHeaderParamsName.USERCODE, "XE73372");
	        headerParamsMap.put(RequestHeaderParamsName.LANGUAGECODE, "es");
	        headerParamsMap.put(RequestHeaderParamsName.OPERATIVEENTITYCODE, "0182");
	        CommonRequestHeader header = new CommonRequestHeader();
	        Whitebox.setInternalState(header, "headerParamsMap", headerParamsMap);
	        CommonRequestBody body = new CommonRequestBody();
	        body.setTransactionParameters(new ArrayList<>());
	        tRequest.setHeader(header);
	        tRequest.setBody(body);
	        return tRequest;
	    }
	
    @Test
	public void testConfig() throws IOException {

    	LogerUtils.textLog(String.format("TestLoc - testPK - **%s",ConstantsLoc.MAILBOX_GCP_PRIVATE_KEY_DV));
    	LogerUtils.textLog(String.format("TestLoc - testPK2 - **%s",String.join("\n", ConstantsLoc.MAILBOX_GCP_PRIVATE_KEY_DV_ARR)));
    	Assert.assertEquals(ConstantsLoc.MAILBOX_GCP_PRIVATE_KEY_DV, String.join("\n", ConstantsLoc.MAILBOX_GCP_PRIVATE_KEY_DV_ARR));
		ElasticSearchRepository esRepo = new ElasticSearchRepository();
		esRepo.toTest();

		Mockito.when(applicationConfigurationService.getProperty(SMRERF10Constants.CAPX_RUN_MODE)).thenReturn("LOCAL");
		InfraHelper ih = new InfraHelper(applicationConfigurationService);
		ih.setCrh(commonRequestHeader);

		Mockito.when(commonRequestHeader.getHeaderParameter(RequestHeaderParamsName.USERCODE)).thenReturn("Y927293");

		// Mock JdbcUtils calls
		Mockito.when(this.jdbcUtilsLocal.update(eq(SMRERF10Constants.SQL_INSERT_MAIL),
		anyMap())).thenReturn(1);
		Mockito.when(this.jdbcUtilsLocal.queryForInt(SMRERF10Constants.SQL_COUNT_OLD)).thenReturn(21);
		Mockito.when(this.jdbcUtilsLocal.update(eq(SMRERF10Constants.SQL_DELETE_OLD),
		anyMap())).thenReturn(1);

		Validations val = new Validations(new ArrayList<>());
		ConfigTest.initElas(ih, val);
		ConfigTest.initOrac(ih);

		OracleH2BBDD oracle = new OracleH2BBDD();
		oracle.toTest();
		
		
		byte [] s1=EncriptadorAES.cifrarV1(ConstantsLoc.MAILBOX_GCP_PRIVATE_KEY_DV, CAPX_GCP_MASTER_PW_DV);
		byte [] s2=EncriptadorAES.cifrarV1(ConstantsLoc.IAP_CLIENT_ID_DV, CAPX_GCP_MASTER_PW_DV);
		LogerUtils.textLog(String.format("%s Encriptado GCP_PRIVATE_KEY=%s",SMRERF10Constants.SEM_LOG,s1));
		LogerUtils.textLog(String.format("%s Encriptado IAP_CLIENT_ID=%s",SMRERF10Constants.SEM_LOG,s2));

		String s3=EncriptadorAES.descifrarV1(s1, CAPX_GCP_MASTER_PW_DV);
		String s4=EncriptadorAES.descifrarV1(s2, CAPX_GCP_MASTER_PW_DV);
		
		Assert.assertEquals(ConstantsLoc.MAILBOX_GCP_PRIVATE_KEY_DV, s3);
		Assert.assertEquals(ConstantsLoc.IAP_CLIENT_ID_DV, s4);
		
		//_java.nio.file.Files.write(java.nio.file.Path.of(BP, "GCP_PRIVATE_KEY.bin"), s1)_
		//_java.nio.file.Files.write(java.nio.file.Path.of(BP, "IAP_CLIENT_ID.bin"), s2)_

		EncriptadorAES.toTest();
		Assert.assertNotNull(ih);
	}

}
