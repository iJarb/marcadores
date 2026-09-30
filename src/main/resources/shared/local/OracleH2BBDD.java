package com.bbva.smre.lib.rf10.local;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.bbva.smre.lib.rf10.interfaces.IBbddOperations;

public class OracleH2BBDD implements IBbddOperations {
	
	private static final  String FICHERO_SQLS = "src/main/resources/sql-SMRERF10IMPL.properties";
	private static final  String OS = System.getProperty("os.name");	
	private static final  String PORT_TCP_H2  = ""; // 9092
	private static        String urlBBDD     = "";
	private static final  String USER_BBDD    = "srme";
	private static final  String CLAVE_BBDD   = "srme";
	
	static Properties prop = new Properties();
	
	
	
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(OracleH2BBDD.class);
	
	private static final String SQL_FROM_PROP="1";
	
    private static JdbcTemplate jdbcTemplate;	
    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;                            				
	
	private static int countConnect=0;
	
	private static void resolvePaths() {
		String rutaH2Bd = "";
		if(!urlBBDD.isEmpty()) {
			return;
		}
		if(OS.contains("Mac")) {
			rutaH2Bd = "/opt/local/bbdd/srme.h2/srme";
		} else {
			rutaH2Bd = "C:/apps/h2/bbdd/smre.h2/smre";
		}
		urlBBDD     = "jdbc:h2:file:/"+rutaH2Bd;
		if(PORT_TCP_H2.length()==4) {
		  urlBBDD = "jdbc:h2:tcp://localhost:"+PORT_TCP_H2+"/srme;DB_CLOSE_DELAY=-1;AUTO_RECONNECT=TRUE";
		}
	}
	
	private static void connectWrapperBBDD() {
		
		
		if(jdbcTemplate!=null && namedParameterJdbcTemplate!=null && countConnect==1) return;
				
		countConnect=1;
		
		connectBBDD();
		
		
    }
	
	private static void connectBBDD() {
		resolvePaths();   				
        SimpleDriverDataSource ds = new SimpleDriverDataSource();
        ds.setDriver(new org.h2.Driver());
        ds.setUrl(urlBBDD);
        ds.setUsername(USER_BBDD);
        ds.setPassword(CLAVE_BBDD);                        
        
        try {
          jdbcTemplate = new JdbcTemplate(ds);     
          namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
        } catch (Exception ex) {
	    	 LOGGER.debug(ex.getMessage());
	     }
		
	}
	
	
	
	private static String getQuery(String sqlIn)   {
		
		if(SQL_FROM_PROP.equals("1")) {
		  try {
			return getSqlFromProperties(sqlIn);
		} catch (IOException e) {
			LOGGER.debug(e.getMessage());
		}
		}
		
		return "";

		
	}	
	
	public Map<String, Object> queryForMap(String query) {
		if (query == null) {
			return new HashMap<>();
		}
		connectWrapperBBDD();
		if (jdbcTemplate != null) {
			String sqlForJdbc = getQuery(query);
			if (sqlForJdbc != null && sqlForJdbc.length() > 5) {
				try {
					return jdbcTemplate.queryForMap(getQuery(query));
				} catch (IncorrectResultSizeDataAccessException e) {
					return new HashMap<>();
				} catch (Exception ex) {
					LOGGER.debug(ex.getMessage());
				}

			} else {
				return new HashMap<>();
			}
		}

		return new HashMap<>();

	}
	
	public Map<String, Object> queryForMap(String query,Map<String, Object> mapInput)  {
		if (query == null) {
			return new HashMap<>();
		}
		connectWrapperBBDD();
		if(namedParameterJdbcTemplate!=null) {
		  String sqlForJdbc=getQuery(query);
		  if(sqlForJdbc!=null && sqlForJdbc.length()>5) {
			 try { 			  			  
			    return namedParameterJdbcTemplate.queryForMap(sqlForJdbc,mapInput);
		     } catch(IncorrectResultSizeDataAccessException e) {
		    	 return new HashMap<>();
		     } catch (Exception ex) {
		    	 LOGGER.debug(ex.getMessage());
		     }
			  
			  
		  } else {
			  return new HashMap<>();
		  }
		}
					
		return new HashMap<>();
		
	}
	
	public List<Map<String, Object>> queryForList(String query) {
		if (query == null) {
			return Collections.emptyList();
		}
		connectWrapperBBDD();
		if (jdbcTemplate != null) {
			String sqlForJdbc = getQuery(query);
			if (sqlForJdbc != null && sqlForJdbc.length() > 5) {
				try {
					return jdbcTemplate.queryForList(sqlForJdbc);					
				} catch (IncorrectResultSizeDataAccessException e) {
					return Collections.emptyList();
				} catch (Exception ex) {
					LOGGER.debug(ex.getMessage());
				}
			} else {
				return Collections.emptyList();
			}
		}

		return Collections.emptyList();

	}
	
	public List<Map<String, Object>> queryForList(String query, Map<String, Object> mapInput) {
		if (query == null) {
			return Collections.emptyList();
		}
		connectWrapperBBDD();
		if (namedParameterJdbcTemplate != null) {
			String sqlForJdbc = getQuery(query);
			if (sqlForJdbc != null && sqlForJdbc.length() > 5) {
				try {
					return namedParameterJdbcTemplate.queryForList(sqlForJdbc, mapInput);					
				} catch (IncorrectResultSizeDataAccessException e) {
					return Collections.emptyList();
				} catch (Exception ex) {
					LOGGER.debug(ex.getMessage());
				}
			} else {
				return Collections.emptyList();
			}
		}

		return Collections.emptyList();

	}
	
	public int[] batchUpdate(String query, Map<String, Object>[] lstmap)  {

		if (query == null) {
			return new int[0];
		}
		connectWrapperBBDD();

		if (namedParameterJdbcTemplate != null) {
			String sqlForJdbc = getQuery(query);
			if (sqlForJdbc != null && sqlForJdbc.length() > 5) {
				try {
				return namedParameterJdbcTemplate.batchUpdate(sqlForJdbc, lstmap);
				} catch (DuplicateKeyException ex) {
					LOGGER.info(ex.getLocalizedMessage());
				} catch (Exception ex) {
			    	 LOGGER.debug(ex.getMessage());
			     }
			} else {
				return new int[0];
			}
		}
		return new int[0];

	}
	
	public int update(String query, Map<String, Object> mapIn)  {

		if (query == null) {
			return 0;
		}
		connectWrapperBBDD();

		if (namedParameterJdbcTemplate != null) {
			String sqlForJdbc = getQuery(query);
			if (sqlForJdbc != null && sqlForJdbc.length() > 5) {
				try {
				return namedParameterJdbcTemplate.update(sqlForJdbc, mapIn);
				} catch (DuplicateKeyException ex) {
					LOGGER.info(ex.getLocalizedMessage());
				} catch (Exception ex) {
			    	 LOGGER.debug(ex.getMessage());
			     }
			} else {
				return 0;
			}
		}
		return 0;

	}
	
	public int update(String query)  {

		if (query == null) {
			return 0;
		}
		connectWrapperBBDD();

		if (jdbcTemplate != null) {
			String sqlForJdbc = getQuery(query);
			if (sqlForJdbc != null && sqlForJdbc.length() > 5) {
				try {
				return jdbcTemplate.update(sqlForJdbc);
				} catch (DuplicateKeyException ex) {
					LOGGER.info(ex.getLocalizedMessage());
				} catch (Exception ex) {
			    	 LOGGER.debug(ex.getMessage());
			     }
			} else {
				return 0;
			}
		}
		return 0;

	}
	
	public List<Map<String, Object>> pagingQueryForList(String query,int offset,int nrows, Map<String, Object> mapInput) {
		if (query == null) {
			return Collections.emptyList();
		}
		connectWrapperBBDD();
		if (namedParameterJdbcTemplate != null) {
			String sqlForJdbc = getQuery(query);
			if (sqlForJdbc != null && sqlForJdbc.length() > 5) {
				try {
					sqlForJdbc += "OFFSET :offset ROWS  FETCH NEXT :nrows ROWS ONLY ";
					mapInput.put("offset", offset);
					mapInput.put("nrows", nrows);
					return namedParameterJdbcTemplate.queryForList(sqlForJdbc, mapInput);
				} catch (IncorrectResultSizeDataAccessException e) {
					return Collections.emptyList();
				} catch (Exception ex) {
					LOGGER.debug(ex.getMessage());
				}
			} else {
				return Collections.emptyList();
			}
		}

		return Collections.emptyList();

	}
	
	
	private static String getSqlFromProperties(String sqlIn) throws IOException  {

		String sqlOut = null;						
						
		
		if(prop.isEmpty()) {		
		  prop.load(new FileInputStream(FICHERO_SQLS));
		}

		sqlOut = prop.getProperty(sqlIn);

		if(sqlOut!=null) {
		  String[] sqlarray = sqlOut.split(";");
		  return sqlarray[1];
		} else {
			return "";
		}

	}

	public int update(String query, String status, String mailId) {
		if (query == null) {
			return 0;
		}
		connectWrapperBBDD();

		if (jdbcTemplate != null) {
			String sqlForJdbc = getQuery(query);
			if (sqlForJdbc != null && sqlForJdbc.length() > 5) {
				try {
				return jdbcTemplate.update(sqlForJdbc, status, mailId);
				} catch (DuplicateKeyException ex) {
					LOGGER.info(ex.getLocalizedMessage());
				} catch (Exception ex) {
			    	 LOGGER.debug(ex.getMessage());
			     }
			} else {
				return 0;
			}
		}
		return 0;
	}

	public int queryForInt(String query) {
		if (query == null) {
			return 0;
		}
		connectWrapperBBDD();
		if (jdbcTemplate != null) {
			String sqlForJdbc = getQuery(query);
			if (sqlForJdbc != null && sqlForJdbc.length() > 5) {
				try {
					Number number = jdbcTemplate.queryForObject(query, Integer.class);
				    return (number != null ? number.intValue() : 0);
				} catch (IncorrectResultSizeDataAccessException e) {
					return 0;
				} catch (Exception ex) {
					LOGGER.debug(ex.getMessage());
				}

			} else {
				return 0;
			}
		}

		return 0;
	}	
	
	public void toTest() throws IOException {
		queryForMap(null);
		queryForMap(null, null);
		queryForList(null);
		queryForList(null, null);
		pagingQueryForList(null,0,1, null);
		batchUpdate(null, null);
		update(null, null);
		update("");
		update(null, "", "");
		queryForInt(null);
		getSqlFromProperties("smre.deleteOldMails");
		
	}

}
