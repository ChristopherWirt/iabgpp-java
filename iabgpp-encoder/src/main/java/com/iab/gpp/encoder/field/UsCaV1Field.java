package com.iab.gpp.encoder.field;

import java.util.Arrays;
import java.util.List;

public class UsCaV1Field {

  public static String VERSION = "Version";
  public static String SALE_OPT_OUT_NOTICE = "SaleOptOutNotice";
  public static String SHARING_OPT_OUT_NOTICE = "SharingOptOutNotice";
  public static String SENSITIVE_DATA_LIMIT_USE_NOTICE = "SensitiveDataLimitUseNotice";
  public static String SALE_OPT_OUT = "SaleOptOut";
  public static String SHARING_OPT_OUT = "SharingOptOut";
  public static String SENSITIVE_DATA_PROCESSING = "SensitiveDataProcessing";
  public static String KNOWN_CHILD_SENSITIVE_DATA_CONSENTS = "KnownChildSensitiveDataConsents";
  public static String PERSONAL_DATA_CONSENTS = "PersonalDataConsents";
  public static String MSPA_COVERED_TRANSACTION = "MspaCoveredTransaction";
  public static String MSPA_OPT_OUT_OPTION_MODE = "MspaOptOutOptionMode";
  public static String MSPA_SERVICE_PROVIDER_MODE = "MspaServiceProviderMode";

  public static String GPC_SEGMENT_TYPE = "GpcSegmentType";
  public static String GPC_SEGMENT_INCLUDED = "GpcSegmentIncluded";
  public static String GPC = "Gpc";

  //@formatter:off
  public static List<String> USCAV1_CORE_SEGMENT_FIELD_NAMES = Arrays.asList(new String[] {
      UsCaV1Field.VERSION,
      UsCaV1Field.SALE_OPT_OUT_NOTICE,
      UsCaV1Field.SHARING_OPT_OUT_NOTICE,
      UsCaV1Field.SENSITIVE_DATA_LIMIT_USE_NOTICE,
      UsCaV1Field.SALE_OPT_OUT,
      UsCaV1Field.SHARING_OPT_OUT,
      UsCaV1Field.SENSITIVE_DATA_PROCESSING,
      UsCaV1Field.KNOWN_CHILD_SENSITIVE_DATA_CONSENTS,
      UsCaV1Field.PERSONAL_DATA_CONSENTS,
      UsCaV1Field.MSPA_COVERED_TRANSACTION,
      UsCaV1Field.MSPA_OPT_OUT_OPTION_MODE,
      UsCaV1Field.MSPA_SERVICE_PROVIDER_MODE
  });
  //@formatter:on

  //@formatter:off
  public static List<String> USCAV1_GPC_SEGMENT_FIELD_NAMES = Arrays.asList(new String[] {
      UsCaV1Field.GPC_SEGMENT_TYPE,
      UsCaV1Field.GPC
  });
  //@formatter:on
}
