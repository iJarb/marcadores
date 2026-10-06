#!/bin/bash
#
# Script generado desde PWD para creación de INDICE
# Version 2020-10-09 - ElasticSearch versión 7.6
#
# Novedades en esta versión:
# ElasticSearch versión 7.6
# HELP:
#
# WARNING:
# Si el índice ya existe y se especifica el flag "-d", será borrado con todos sus datos
#

# VARIABLES:
HOSTNAME=$1
USER=$2
PASSWORD=$3
INDICE=$4
shards=$5
replicas=$6
seconds=$7
ANYO=$8

STARK_ALIAS=i_smre_es_posit_coord_court_ai

STARK_SEED_DATE=01/01/2001
STARK_DEPTH=0
STARK_PERIODICITY=none
STARK_TYPE=New
STARK_VOLUMETRY=25.000
STARK_SIZE=100
STARK_SIZEDB=2.500.000
STARK_FLIP_FLOP=no

# Llamada CUrl:
curl -X PUT -H'Content-Type: application/json' -u $USER:$PASSWORD 'https://'$HOSTNAME'/'$INDICE'' -d'{
        "settings": {
        "number_of_replicas": '$replicas',
        "number_of_shards": '$shards',
        "number_of_routing_shards": '$shards',
        "refresh_interval": "'$seconds'",
        "index.search.slowlog.threshold.query.warn": "200ms",
        "index.search.slowlog.threshold.query.trace": "100ms",
        "index.search.slowlog.threshold.fetch.warn": "200ms",
        "index.search.slowlog.threshold.fetch.trace": "100ms",
        "index.indexing.slowlog.threshold.index.warn": "600ms",
        "index.indexing.slowlog.threshold.index.trace": "500ms",
 "index.codec" : "best_compression"
},
         
  "mappings": {
    "dynamic": "strict",
    "_routing": {
      "required": true
    },
    "properties": {
      "mailbox_desc": {
        "type": "keyword"
      },
      "mail_uniq_id": {
        "type": "keyword"
      },
      "judicial_file_id": {
        "type": "keyword"
      },
      "court_order_id": {
        "type": "short"
      },
      "miof_court_order_id": {
        "type": "keyword"
      },
      "related_judicial_file_id": {
        "type": "keyword"
      },
      "tk_task_id": {
        "type": "keyword"
      },
      "court_order_type_id": {
        "type": "keyword"
      },
      "court_order_sub_type": {
        "type": "keyword"
      },
      "taxonomy_reason_id": {
        "type": "keyword"
      },
      "complaint_register_status_type": {
        "type": "keyword"
      },
      "organism_str": {
        "type": "nested",
        "properties": {
          "pu_organism_id": {
            "type": "keyword"
          },
          "organism_type": {
            "type": "keyword"
          },
          "pu_organism_subtype_id": {
            "type": "keyword"
          },
          "pu_external_public_organism_id": {
            "type": "keyword"
          },
          "pu_organism_scope_id": {
            "type": "keyword"
          }
        }
      },
      "comp_str": {
        "type": "nested",
        "properties": {
          "internal_intervention_type_desc": {
            "type": "keyword"
          },
          "personal_type_desc": {
            "type": "keyword"
          },
          "personal_id": {
            "type": "keyword"
          },
          "loc_pers_id_str": {
            "type": "nested",
            "properties": {
              "document_desc": {
                "type": "keyword"
              },
              "document_page_number": {
                "type": "short"
              }
            }
          },
          "customer_complete_name": {
            "type": "keyword"
          },
          "loc_cus_compl_name_str": {
            "type": "nested",
            "properties": {
              "document_desc": {
                "type": "keyword"
              },
              "document_page_number": {
                "type": "short"
              }
            }
          },
          "email_desc": {
            "type": "keyword"
          },
          "loc_email_str": {
            "type": "nested",
            "properties": {
              "document_desc": {
                "type": "keyword"
              },
              "document_page_number": {
                "type": "short"
              }
            }
          }
        }
      },
      "loc_pu_org_ref_id_str": {
        "type": "nested",
        "properties": {
          "document_desc": {
            "type": "keyword"
          },
          "document_page_number": {
            "type": "short"
          }
        }
      },
      "loc_comp_id_str": {
        "type": "nested",
        "properties": {
          "document_desc": {
            "type": "keyword"
          },
          "document_page_number": {
            "type": "short"
          }
        }
      },
      "isses_str": {
        "type": "nested",
        "properties": {
          "total_claim_amount": {
            "type": "keyword"
          },
          "currency_id": {
            "type": "keyword"
          },
          "loc_claim_amont_str": {
            "type": "nested",
            "properties": {
              "document_desc": {
                "type": "keyword"
              },
              "document_page_number": {
                "type": "short"
              }
            }
          },
          "entry_settlement_date": {
            "type": "date"
          },
          "contract_type_desc": {
            "type": "keyword"
          },
          "con_id_str": {
            "type": "nested",
            "properties": {
              "contract_country_id": {
                "type": "keyword"
              },
              "contract_entity_id": {
                "type": "keyword"
              },
              "contract_id": {
                "type": "keyword"
              },
              "dependent_id": {
                "type": "keyword"
              },
              "counterpart_id": {
                "type": "keyword"
              }
            }
          },
          "bocf_str": {
            "type": "nested",
            "properties": {
              "entity_page_id": {
                "type": "keyword"
              },
              "branch_page_id": {
                "type": "keyword"
              },
              "counterpart_id": {
                "type": "keyword"
              },
              "page_id": {
                "type": "keyword"
              }
            }
          },
          "ccc_str": {
            "properties": {
              "contract_type": {
                "type": "keyword"
              },
              "external_contract_id": {
                "type": "keyword"
              }
            }
          },
          "loc_con_id_str": {
            "type": "nested",
            "properties": {
              "document_desc": {
                "type": "keyword"
              },
              "document_page_number": {
                "type": "short"
              }
            }
          },
          "loc_exec_date_str": {
            "type": "nested",
            "properties": {
              "document_desc": {
                "type": "keyword"
              },
              "document_page_number": {
                "type": "short"
              }
            }
          },
          "blind_pan_id": {
            "type": "keyword"
          },
          "loc_pan_ofus_cont_id_str": {
            "type": "nested",
            "properties": {
              "document_desc": {
                "type": "keyword"
              },
              "document_page_number": {
                "type": "short"
              }
            }
          },
          "taxo_str": {
            "type": "nested",
            "properties": {
              "complaint_taxonomy_id": {
                "type": "integer"
              },
              "complaint_taxonomy_desc": {
                "type": "keyword"
              }
            }
          },
          "entity_ass_to_claimed_issue_id": {
            "type": "keyword"
          }
        }
      },
      "event_str": {
        "type": "nested",
        "properties": {
          "email_reception_date": {
            "type": "date"
          },
          "claimed_issue_email_desc": {
            "type": "keyword"
          },
          "sender_email_desc": {
            "type": "keyword"
          },
          "destination_email_desc": {
            "type": "keyword"
          }
        }
      },
      "robot_str": {
        "type": "nested",
        "properties": {
          "task_priority_type": {
            "type": "keyword"
          },
          "respondent_id": {
            "type": "keyword"
          },
          "respondent_type": {
            "type": "keyword"
          },
          "court_order_resp_docum_number": {
            "type": "keyword"
          },
          "cor_proceding_type_id": {
            "type": "keyword"
          }
        }
      },
      "court_order_str": {
        "properties": {
          "authorized_organism_str": {
            "type": "nested",
            "properties": {
              "organism_str": {
                "type": "nested",
                "properties": {
                  "pu_organism_id": {
                    "type": "keyword"
                  },
                  "organism_type": {
                    "type": "keyword"
                  },
                  "pu_organism_subtype_id": {
                    "type": "keyword"
                  },
                  "pu_external_public_organism_id": {
                    "type": "keyword"
                  },
                  "pu_organism_scope_id": {
                    "type": "keyword"
                  }
                }
              },
              "proceeding_number_id": {
                "type": "keyword"
              },
              "cor_proceding_type_id": {
                "type": "keyword"
              },
              "pu_organism_reference_id": {
                "type": "keyword"
              },
              "entry_date": {
                "type": "date"
              },
              "respondent_str": {
                "type": "nested",
                "properties": {
                  "identity_document_str": {
                    "type": "nested",
                    "properties": {
                      "first_personal_id": {
                        "type": "keyword"
                      },
                      "group_document_type": {
                        "type": "keyword"
                      }
                    }
                  },
                  "full_name": {
                    "type": "keyword"
                  },
                  "entity_id": {
                    "type": "keyword"
                  },
                  "customer_id": {
                    "type": "keyword"
                  },
                  "respondent_id": {
                    "type": "keyword"
                  },
                  "respondent_type": {
                    "type": "keyword"
                  }
                }
              },
              "type_court_order_str": {
                "type": "nested",
                "properties": {
                  "court_order_type_id": {
                    "type": "keyword"
                  },
                  "court_order_sub_types_str": {
                    "type": "nested",
                    "properties": {
                      "court_typology_type": {
                        "type": "keyword"
                      },
                      "court_id": {
                        "type": "keyword"
                      }
                    }
                  }
                }
              },
              "high_critical_event_str": {
                "type": "nested",
                "properties": {
                  "high_criticality_event_type": {
                    "type": "keyword"
                  }
                }
              },
              "input_channel_str": {
                "type": "nested",
                "properties": {
                  "input_channel_type": {
                    "type": "keyword"
                  }
                }
              },
              "document_str": {
                "type": "nested",
                "properties": {
                  "mail_attachment_id": {
                    "type": "keyword"
                  },
                  "attachment_type_id": {
                    "type": "keyword"
                  },
                  "attachment_name": {
                    "type": "keyword"
                  }
                }
              },
              "indicator_str": {
                "properties": {
                  "entity_employee_type": {
                    "type": "keyword"
                  },
                  "entity_defendant_type": {
                    "type": "keyword"
                  },
                  "secret_court_order_type": {
                    "type": "keyword"
                  },
                  "no_contact_branch_type": {
                    "type": "keyword"
                  },
                  "judicial_notice_type": {
                    "type": "keyword"
                  },
                  "disobedence_warning_court_type": {
                    "type": "keyword"
                  },
                  "judicial_notice_number": {
                    "type": "keyword"
                  }
                }
              },
              "contracts_str": {
                "type": "nested",
                "properties": {
                  "contract_required_id": {
                    "type": "keyword"
                  }
                }
              },
              "seizures_str": {
                "properties": {
                  "cor_court_order_amount": {
                    "type": "keyword"
                  },
                  "product_type_str": {
                    "type": "nested",
                    "properties": {
                      "seizure_product_type_id": {
                        "type": "keyword"
                      }
                    }
                  }
                }
              },
              "notification_date": {
                "type": "date"
              }
            }
          }
        }
      },
      "audit_user_id": {
        "type": "keyword"
      },
      "audit_date": {
        "type": "date"
      }
    }
  }

}'
if [ -n "$ANYO" ];then
  curl -XPOST -H'Content-Type: application/json' -u $USER:$PASSWORD 'https://'$HOSTNAME'/_aliases' -d'{
  "actions" : [
  { "add" : { "index" : "'$INDICE'", "alias" : "'$STARK_ALIAS'_'$ANYO'" } }
  ]
  }'
  
else
  curl -XPOST -H'Content-Type: application/json' -u $USER:$PASSWORD 'https://'$HOSTNAME'/_aliases' -d'{
  "actions" : [
  { "add" : { "index" : "'$INDICE'", "alias" : "'$STARK_ALIAS'" } }
  ]
  }'
fi