package ru.bogdan.testtaskvodovoz.data.web.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("CATALOG_AVAILABLE")
    val cATALOGAVAILABLE: String,
    @SerializedName("CATALOG_BUNDLE")
    val cATALOGBUNDLE: String,
    @SerializedName("CATALOG_CAN_BUY_ZERO")
    val cATALOGCANBUYZERO: String,
    @SerializedName("CATALOG_CAN_BUY_ZERO_ORIG")
    val cATALOGCANBUYZEROORIG: String,
    @SerializedName("CATALOG_HEIGHT")
    val cATALOGHEIGHT: String,
    @SerializedName("CATALOG_LENGTH")
    val cATALOGLENGTH: String,
    @SerializedName("CATALOG_MEASURE")
    val cATALOGMEASURE: String,
    @SerializedName("CATALOG_NEGATIVE_AMOUNT_TRACE")
    val cATALOGNEGATIVEAMOUNTTRACE: String,
    @SerializedName("CATALOG_NEGATIVE_AMOUNT_TRACE_ORIG")
    val cATALOGNEGATIVEAMOUNTTRACEORIG: String,
    @SerializedName("CATALOG_PRICE_TYPE")
    val cATALOGPRICETYPE: String,
    @SerializedName("CATALOG_PURCHASING_CURRENCY")
    val cATALOGPURCHASINGCURRENCY: String,
    @SerializedName("CATALOG_PURCHASING_PRICE")
    val cATALOGPURCHASINGPRICE: String,
    @SerializedName("CATALOG_QUANTITY")
    val cATALOGQUANTITY: Int,
    @SerializedName("CATALOG_QUANTITY_RESERVED")
    val cATALOGQUANTITYRESERVED: String,
    @SerializedName("CATALOG_QUANTITY_TRACE")
    val cATALOGQUANTITYTRACE: String,
    @SerializedName("CATALOG_QUANTITY_TRACE_ORIG")
    val cATALOGQUANTITYTRACEORIG: String,
    @SerializedName("CATALOG_RECUR_SCHEME_LENGTH")
    val cATALOGRECURSCHEMELENGTH: String,
    @SerializedName("CATALOG_RECUR_SCHEME_TYPE")
    val cATALOGRECURSCHEMETYPE: String,
    @SerializedName("CATALOG_SELECT_BEST_PRICE")
    val cATALOGSELECTBESTPRICE: String,
    @SerializedName("CATALOG_SUBSCRIBE")
    val cATALOGSUBSCRIBE: String,
    @SerializedName("CATALOG_SUBSCRIBE_ORIG")
    val cATALOGSUBSCRIBEORIG: String,
    @SerializedName("CATALOG_TRIAL_PRICE_ID")
    val cATALOGTRIALPRICEID: Any,
    @SerializedName("CATALOG_TYPE")
    val cATALOGTYPE: String,
    @SerializedName("CATALOG_VAT")
    val cATALOGVAT: String,
    @SerializedName("CATALOG_VAT_ID")
    val cATALOGVATID: String,
    @SerializedName("CATALOG_VAT_INCLUDED")
    val cATALOGVATINCLUDED: String,
    @SerializedName("CATALOG_WEIGHT")
    val cATALOGWEIGHT: String,
    @SerializedName("CATALOG_WIDTH")
    val cATALOGWIDTH: String,
    @SerializedName("CATALOG_WITHOUT_ORDER")
    val cATALOGWITHOUTORDER: String,
    @SerializedName("COUTCOMMENTS")
    val cOUTCOMMENTS: String,
    @SerializedName("DATE_ACTIVE_FROM")
    val dATEACTIVEFROM: Any,
    @SerializedName("DETAIL_PICTURE")
    val dETAILPICTURE: String,
    @SerializedName("EDINICAIZMERENIYA")
    val eDINICAIZMERENIYA: Any,
    @SerializedName("EXTENDED_PRICE")
    val eXTENDEDPRICE: List<ExtendedPrice>,
    @SerializedName("FAVORITE")
    val fAVORITE: Boolean,
    @SerializedName("IBLOCK_ID")
    val iBLOCKID: String,
    @SerializedName("ID")
    val iD: String,
    @SerializedName("KOFFICIENT")
    val kOFFICIENT: Int,
    @SerializedName("MORE_PHOTO")
    val mOREPHOTO: MorePhoto,
    @SerializedName("NALICHIE")
    val nALICHIE: Nalichie,
    @SerializedName("NAME")
    val nAME: Any,
    @SerializedName("NewPrice")
    val newPrice: NewPrice,
    @SerializedName("PROPERTY_NEWPRODUCT_ENUM_ID")
    val pROPERTYNEWPRODUCTENUMID: Any,
    @SerializedName("PROPERTY_NEWPRODUCT_VALUE")
    val pROPERTYNEWPRODUCTVALUE: Any,
    @SerializedName("PROPERTY_NEWPRODUCT_VALUE_ID")
    val pROPERTYNEWPRODUCTVALUEID: Any,
    @SerializedName("PROPERTY_PODAROK_ENUM_ID")
    val pROPERTYPODAROKENUMID: Any,
    @SerializedName("PROPERTY_PODAROK_VALUE")
    val pROPERTYPODAROKVALUE: Any,
    @SerializedName("PROPERTY_PODAROK_VALUE_ID")
    val pROPERTYPODAROKVALUEID: Any,
    @SerializedName("PROPERTY_RATING_VALUE")
    val pROPERTYRATINGVALUE: Double,
    @SerializedName("PROPERTY_RATING_VALUE_ID")
    val pROPERTYRATINGVALUEID: String,
    @SerializedName("PROPERTY_SALELEADER_ENUM_ID")
    val pROPERTYSALELEADERENUMID: Any,
    @SerializedName("PROPERTY_SALELEADER_VALUE")
    val pROPERTYSALELEADERVALUE: Any,
    @SerializedName("PROPERTY_SALELEADER_VALUE_ID")
    val pROPERTYSALELEADERVALUEID: Any,
    @SerializedName("PROPERTY_TSENA_ZA_EDINITSU_TOVARA_VALUE")
    val pROPERTYTSENAZAEDINITSUTOVARAVALUE: Int,
    @SerializedName("PROPERTY_TSENA_ZA_EDINITSU_TOVARA_VALUE_ID")
    val pROPERTYTSENAZAEDINITSUTOVARAVALUEID: String,
    @SerializedName("PROPERTY_ZALOG_VALUE")
    val pROPERTYZALOGVALUE: Int
)