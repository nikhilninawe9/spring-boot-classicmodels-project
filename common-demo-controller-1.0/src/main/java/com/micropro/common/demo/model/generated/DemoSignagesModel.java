package com.micropro.common.demo.model.generated;

import java.sql.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class DemoSignagesModel {

	@JsonInclude(Include.ALWAYS)
	@JsonIgnoreProperties(ignoreUnknown = true)
	@ApiModel(description = "A request body model used in POST requests to create a DemoSignages entity")
	public static final class DemoSignagesBody {

		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSIGNBDNHDR_BODY' (required)") InsignbdnhdrBody insignbdnhdr;

		@JsonCreator
		public DemoSignagesBody(
				@JsonProperty("insignbdnhdr") InsignbdnhdrBody insignbdnhdr) {
			this.insignbdnhdr = Objects.requireNonNull(insignbdnhdr, "`insignbdnhdr` is required");
		}

		public InsignbdnhdrBody getInsignbdnhdr() {
			return insignbdnhdr;
		}
	}

	@JsonInclude(Include.ALWAYS)
	@JsonIgnoreProperties(ignoreUnknown = true)
	@ApiModel(description = "A request body model used in POST requests to create a Insignbdnhdr entity")
	public static final class InsignbdnhdrBody {

		private @ApiModelProperty(required = false, value = "REST representation of the 'INSIGNBDNHDRID_BODY' (Primary Key)") Long insignbdnhdrid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBHORGID_BODY' (required) (Size = 5)") Integer insbhorgid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBHOPRID_BODY' (required) (Size = 5)") Integer insbhoprid;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHDOCNO_BODY' (Size = 20)") String insbhdocno;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHDOCDT_BODY'") Date insbhdocdt;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHOPRIDBR_BODY' (Size = 20)") Long insbhopridbr;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHOPRIDSDIS_BODY' (Size = 20)") Long insbhopridsdis;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHOPRIDDIS_BODY' (Size = 20)") Long insbhopriddis;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHSDISPARTYID_BODY' (Size = 20)") Long insbhsdispartyid;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHDISPARTYID_BODY' (Size = 20)") Long insbhdispartyid;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHSALESSTAFF_BODY' (Size = 100)") String insbhsalesstaff;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHTYPE_BODY' (Size = 1)") String insbhtype;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHABMRBM_BODY' (Size = 100)") String insbhabmrbm;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHBDNTYPE_BODY' (Size = 1)") String insbhbdntype;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHAPPROVED1_BODY' (Size = 1)") String insbhapproved1;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHARDT1_BODY'") Date insbhardt1;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHAPRBY1_BODY' (Size = 20)") Long insbhaprby1;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHREASON1_BODY' (Size = 50)") String insbhreason1;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHAPPROVED2_BODY' (Size = 1)") String insbhapproved2;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHARDT2_BODY'") Date insbhardt2;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHAPRBY2_BODY' (Size = 20)") Long insbhaprby2;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHREASON2_BODY' (Size = 50)") String insbhreason2;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHAPPROVED3_BODY' (Size = 1)") String insbhapproved3;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHARDT3_BODY'") Date insbhardt3;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHAPRBY3_BODY' (Size = 20)") Long insbhaprby3;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHREASON3_BODY' (Size = 50)") String insbhreason3;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHAPPROVED4_BODY' (Size = 1)") String insbhapproved4;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHARDT4_BODY'") Date insbhardt4;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHAPRBY4_BODY' (Size = 20)") Long insbhaprby4;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHREASON4_BODY' (Size = 50)") String insbhreason4;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHPENFOR_BODY' (Size = 200)") String insbhpenfor;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHBALBUD_BODY' (Size = 17,2)") BigDecimal insbhbalbud;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHVENID_BODY' (Size = 20)") Long insbhvenid;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHHODSTAFF_BODY' (Size = 100)") String insbhhodstaff;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHVALUE_BODY' (Size = 17,4)") BigDecimal insbhvalue;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHTVALUE_BODY' (Size = 17,4)") BigDecimal insbhtvalue;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHNVALUE_BODY' (Size = 17,4)") BigDecimal insbhnvalue;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHTAXCAT_BODY' (Size = 20)") Long insbhtaxcat;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'CREATEDON_BODY' (required)") Timestamp createdon;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'CREATEDBY_BODY' (required) (Size = 20)") Long createdby;
		private @ApiModelProperty(required = false, value = "REST representation of the 'MODIFYON_BODY'") Timestamp modifyon;
		private @ApiModelProperty(required = false, value = "REST representation of the 'MODIFYBY_BODY' (Size = 20)") Long modifyby;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'LASTOPERATION_BODY' (required) (Size = 10)") String lastoperation;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBHDOCUPLODID_BODY' (Size = 20)") Long insbhdocuplodid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSIGNBDNDTL_BODY' (required)") List<InsignbdndtlBody> insignbdndtl;

		@JsonCreator
		public InsignbdnhdrBody(
				@JsonProperty("insignbdnhdrid") Long insignbdnhdrid,
				@JsonProperty("insbhorgid") Integer insbhorgid,
				@JsonProperty("insbhoprid") Integer insbhoprid,
				@JsonProperty("insbhdocno") String insbhdocno,
				@JsonProperty("insbhdocdt") @JsonFormat(pattern = "yyyy-MM-dd") Date insbhdocdt,
				@JsonProperty("insbhopridbr") Long insbhopridbr,
				@JsonProperty("insbhopridsdis") Long insbhopridsdis,
				@JsonProperty("insbhopriddis") Long insbhopriddis,
				@JsonProperty("insbhsdispartyid") Long insbhsdispartyid,
				@JsonProperty("insbhdispartyid") Long insbhdispartyid,
				@JsonProperty("insbhsalesstaff") String insbhsalesstaff,
				@JsonProperty("insbhtype") String insbhtype,
				@JsonProperty("insbhabmrbm") String insbhabmrbm,
				@JsonProperty("insbhbdntype") String insbhbdntype,
				@JsonProperty("insbhapproved1") String insbhapproved1,
				@JsonProperty("insbhardt1") @JsonFormat(pattern = "yyyy-MM-dd") Date insbhardt1,
				@JsonProperty("insbhaprby1") Long insbhaprby1,
				@JsonProperty("insbhreason1") String insbhreason1,
				@JsonProperty("insbhapproved2") String insbhapproved2,
				@JsonProperty("insbhardt2") @JsonFormat(pattern = "yyyy-MM-dd") Date insbhardt2,
				@JsonProperty("insbhaprby2") Long insbhaprby2,
				@JsonProperty("insbhreason2") String insbhreason2,
				@JsonProperty("insbhapproved3") String insbhapproved3,
				@JsonProperty("insbhardt3") @JsonFormat(pattern = "yyyy-MM-dd") Date insbhardt3,
				@JsonProperty("insbhaprby3") Long insbhaprby3,
				@JsonProperty("insbhreason3") String insbhreason3,
				@JsonProperty("insbhapproved4") String insbhapproved4,
				@JsonProperty("insbhardt4") @JsonFormat(pattern = "yyyy-MM-dd") Date insbhardt4,
				@JsonProperty("insbhaprby4") Long insbhaprby4,
				@JsonProperty("insbhreason4") String insbhreason4,
				@JsonProperty("insbhpenfor") String insbhpenfor,
				@JsonProperty("insbhbalbud") BigDecimal insbhbalbud,
				@JsonProperty("insbhvenid") Long insbhvenid,
				@JsonProperty("insbhhodstaff") String insbhhodstaff,
				@JsonProperty("insbhvalue") BigDecimal insbhvalue,
				@JsonProperty("insbhtvalue") BigDecimal insbhtvalue,
				@JsonProperty("insbhnvalue") BigDecimal insbhnvalue,
				@JsonProperty("insbhtaxcat") Long insbhtaxcat,
				@JsonProperty("createdon") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Timestamp createdon,
				@JsonProperty("createdby") Long createdby,
				@JsonProperty("modifyon") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Timestamp modifyon,
				@JsonProperty("modifyby") Long modifyby,
				@JsonProperty("lastoperation") String lastoperation,
				@JsonProperty("insbhdocuplodid") Long insbhdocuplodid,
				@JsonProperty("insignbdndtl") List<InsignbdndtlBody> insignbdndtl) {
			this.insignbdnhdrid = Objects.requireNonNull(insignbdnhdrid, "`insignbdnhdrid` is required");
			this.insbhorgid = Objects.requireNonNull(insbhorgid, "`insbhorgid` is required");
			this.insbhoprid = Objects.requireNonNull(insbhoprid, "`insbhoprid` is required");
			this.insbhdocno = insbhdocno;
			this.insbhdocdt = insbhdocdt;
			this.insbhopridbr = insbhopridbr;
			this.insbhopridsdis = insbhopridsdis;
			this.insbhopriddis = insbhopriddis;
			this.insbhsdispartyid = insbhsdispartyid;
			this.insbhdispartyid = insbhdispartyid;
			this.insbhsalesstaff = insbhsalesstaff;
			this.insbhtype = insbhtype;
			this.insbhabmrbm = insbhabmrbm;
			this.insbhbdntype = insbhbdntype;
			this.insbhapproved1 = insbhapproved1;
			this.insbhardt1 = insbhardt1;
			this.insbhaprby1 = insbhaprby1;
			this.insbhreason1 = insbhreason1;
			this.insbhapproved2 = insbhapproved2;
			this.insbhardt2 = insbhardt2;
			this.insbhaprby2 = insbhaprby2;
			this.insbhreason2 = insbhreason2;
			this.insbhapproved3 = insbhapproved3;
			this.insbhardt3 = insbhardt3;
			this.insbhaprby3 = insbhaprby3;
			this.insbhreason3 = insbhreason3;
			this.insbhapproved4 = insbhapproved4;
			this.insbhardt4 = insbhardt4;
			this.insbhaprby4 = insbhaprby4;
			this.insbhreason4 = insbhreason4;
			this.insbhpenfor = insbhpenfor;
			this.insbhbalbud = insbhbalbud;
			this.insbhvenid = insbhvenid;
			this.insbhhodstaff = insbhhodstaff;
			this.insbhvalue = insbhvalue;
			this.insbhtvalue = insbhtvalue;
			this.insbhnvalue = insbhnvalue;
			this.insbhtaxcat = insbhtaxcat;
			this.createdon = Objects.requireNonNull(createdon, "`createdon` is required");
			this.createdby = Objects.requireNonNull(createdby, "`createdby` is required");
			this.modifyon = modifyon;
			this.modifyby = modifyby;
			this.lastoperation = Objects.requireNonNull(lastoperation, "`lastoperation` is required");
			this.insbhdocuplodid = insbhdocuplodid;
			this.insignbdndtl = insignbdndtl;
		}

		public Long getInsignbdnhdrid() {
			return insignbdnhdrid;
		}

		public Integer getInsbhorgid() {
			return insbhorgid;
		}

		public Integer getInsbhoprid() {
			return insbhoprid;
		}

		public String getInsbhdocno() {
			return insbhdocno;
		}

		public Date getInsbhdocdt() {
			return insbhdocdt;
		}

		public Long getInsbhopridbr() {
			return insbhopridbr;
		}

		public Long getInsbhopridsdis() {
			return insbhopridsdis;
		}

		public Long getInsbhopriddis() {
			return insbhopriddis;
		}

		public Long getInsbhsdispartyid() {
			return insbhsdispartyid;
		}

		public Long getInsbhdispartyid() {
			return insbhdispartyid;
		}

		public String getInsbhsalesstaff() {
			return insbhsalesstaff;
		}

		public String getInsbhtype() {
			return insbhtype;
		}

		public String getInsbhabmrbm() {
			return insbhabmrbm;
		}

		public String getInsbhbdntype() {
			return insbhbdntype;
		}

		public String getInsbhapproved1() {
			return insbhapproved1;
		}

		public Date getInsbhardt1() {
			return insbhardt1;
		}

		public Long getInsbhaprby1() {
			return insbhaprby1;
		}

		public String getInsbhreason1() {
			return insbhreason1;
		}

		public String getInsbhapproved2() {
			return insbhapproved2;
		}

		public Date getInsbhardt2() {
			return insbhardt2;
		}

		public Long getInsbhaprby2() {
			return insbhaprby2;
		}

		public String getInsbhreason2() {
			return insbhreason2;
		}

		public String getInsbhapproved3() {
			return insbhapproved3;
		}

		public Date getInsbhardt3() {
			return insbhardt3;
		}

		public Long getInsbhaprby3() {
			return insbhaprby3;
		}

		public String getInsbhreason3() {
			return insbhreason3;
		}

		public String getInsbhapproved4() {
			return insbhapproved4;
		}

		public Date getInsbhardt4() {
			return insbhardt4;
		}

		public Long getInsbhaprby4() {
			return insbhaprby4;
		}

		public String getInsbhreason4() {
			return insbhreason4;
		}

		public String getInsbhpenfor() {
			return insbhpenfor;
		}

		public BigDecimal getInsbhbalbud() {
			return insbhbalbud;
		}

		public Long getInsbhvenid() {
			return insbhvenid;
		}

		public String getInsbhhodstaff() {
			return insbhhodstaff;
		}

		public BigDecimal getInsbhvalue() {
			return insbhvalue;
		}

		public BigDecimal getInsbhtvalue() {
			return insbhtvalue;
		}

		public BigDecimal getInsbhnvalue() {
			return insbhnvalue;
		}

		public Long getInsbhtaxcat() {
			return insbhtaxcat;
		}

		public Timestamp getCreatedon() {
			return createdon;
		}

		public Long getCreatedby() {
			return createdby;
		}

		public Timestamp getModifyon() {
			return modifyon;
		}

		public Long getModifyby() {
			return modifyby;
		}

		public String getLastoperation() {
			return lastoperation;
		}

		public Long getInsbhdocuplodid() {
			return insbhdocuplodid;
		}

		public List<InsignbdndtlBody> getInsignbdndtl() {
			return insignbdndtl;
		}
	}

	@JsonInclude(Include.ALWAYS)
	@JsonIgnoreProperties(ignoreUnknown = true)
	@ApiModel(description = "A request body model used in POST requests to create a Insignbdndtl entity")
	public static final class InsignbdndtlBody {

		private @ApiModelProperty(required = false, value = "REST representation of the 'INSIGNBDNDTLID_BODY' (Primary Key)") Long insignbdndtlid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSIGNBDNHDRID_BODY' (required) (Size = 20)") Long insignbdnhdrid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBDDOCSRL_BODY' (required) (Size = 3)") Integer insbddocsrl;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBDPARTYID_BODY' (required) (Size = 20)") Long insbdpartyid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBDITEMID_BODY' (required) (Size = 20)") Long insbditemid;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDQTY_BODY' (Size = 3,0)") Short insbdqty;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBDRATE_BODY' (required) (Size = 17,4)") BigDecimal insbdrate;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBDVALUE_BODY' (required) (Size = 17,4)") BigDecimal insbdvalue;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDTVALUE_BODY' (Size = 17,4)") BigDecimal insbdtvalue;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDNVALUE_BODY' (Size = 17,4)") BigDecimal insbdnvalue;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDHOCOMM_BODY' (Size = 200)") String insbdhocomm;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDTAXCAT_BODY' (Size = 20)") Long insbdtaxcat;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDHEIGHT_BODY' (Size = 6,2)") BigDecimal insbdheight;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDWIDTH_BODY' (Size = 6,2)") BigDecimal insbdwidth;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDSQMT_BODY' (Size = 6,2)") BigDecimal insbdsqmt;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDREMARKS_BODY' (Size = 200)") String insbdremarks;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDBDNCUST_BODY' (Size = 1)") String insbdbdncust;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDLYSIL_BODY' (Size = 15,3)") BigDecimal insbdlysil;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDLYSIDP_BODY' (Size = 15,3)") BigDecimal insbdlysidp;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'CREATEDON_BODY' (required)") Timestamp createdon;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'CREATEDBY_BODY' (required) (Size = 20)") Long createdby;
		private @ApiModelProperty(required = false, value = "REST representation of the 'MODIFYON_BODY'") Timestamp modifyon;
		private @ApiModelProperty(required = false, value = "REST representation of the 'MODIFYBY_BODY' (Size = 20)") Long modifyby;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'LASTOPERATION_BODY' (required) (Size = 10)") String lastoperation;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBDDOCUPLODID_BODY' (Size = 20)") Long insbddocuplodid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSIGNBDNTAXTRN_BODY' (required)") List<InsignbdntaxtrnBody> insignbdntaxtrn;

		@JsonCreator
		public InsignbdndtlBody(
				@JsonProperty("insignbdndtlid") Long insignbdndtlid,
				@JsonProperty("insignbdnhdrid") Long insignbdnhdrid,
				@JsonProperty("insbddocsrl") Integer insbddocsrl,
				@JsonProperty("insbdpartyid") Long insbdpartyid,
				@JsonProperty("insbditemid") Long insbditemid,
				@JsonProperty("insbdqty") Short insbdqty,
				@JsonProperty("insbdrate") BigDecimal insbdrate,
				@JsonProperty("insbdvalue") BigDecimal insbdvalue,
				@JsonProperty("insbdtvalue") BigDecimal insbdtvalue,
				@JsonProperty("insbdnvalue") BigDecimal insbdnvalue,
				@JsonProperty("insbdhocomm") String insbdhocomm,
				@JsonProperty("insbdtaxcat") Long insbdtaxcat,
				@JsonProperty("insbdheight") BigDecimal insbdheight,
				@JsonProperty("insbdwidth") BigDecimal insbdwidth,
				@JsonProperty("insbdsqmt") BigDecimal insbdsqmt,
				@JsonProperty("insbdremarks") String insbdremarks,
				@JsonProperty("insbdbdncust") String insbdbdncust,
				@JsonProperty("insbdlysil") BigDecimal insbdlysil,
				@JsonProperty("insbdlysidp") BigDecimal insbdlysidp,
				@JsonProperty("createdon") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Timestamp createdon,
				@JsonProperty("createdby") Long createdby,
				@JsonProperty("modifyon") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Timestamp modifyon,
				@JsonProperty("modifyby") Long modifyby,
				@JsonProperty("lastoperation") String lastoperation,
				@JsonProperty("insbddocuplodid") Long insbddocuplodid,
				@JsonProperty("insignbdntaxtrn") List<InsignbdntaxtrnBody> insignbdntaxtrn) {
			this.insignbdndtlid = Objects.requireNonNull(insignbdndtlid, "`insignbdndtlid` is required");
			this.insignbdnhdrid = Objects.requireNonNull(insignbdnhdrid, "`insignbdnhdrid` is required");
			this.insbddocsrl = Objects.requireNonNull(insbddocsrl, "`insbddocsrl` is required");
			this.insbdpartyid = Objects.requireNonNull(insbdpartyid, "`insbdpartyid` is required");
			this.insbditemid = Objects.requireNonNull(insbditemid, "`insbditemid` is required");
			this.insbdqty = insbdqty;
			this.insbdrate = Objects.requireNonNull(insbdrate, "`insbdrate` is required");
			this.insbdvalue = Objects.requireNonNull(insbdvalue, "`insbdvalue` is required");
			this.insbdtvalue = insbdtvalue;
			this.insbdnvalue = insbdnvalue;
			this.insbdhocomm = insbdhocomm;
			this.insbdtaxcat = insbdtaxcat;
			this.insbdheight = insbdheight;
			this.insbdwidth = insbdwidth;
			this.insbdsqmt = insbdsqmt;
			this.insbdremarks = insbdremarks;
			this.insbdbdncust = insbdbdncust;
			this.insbdlysil = insbdlysil;
			this.insbdlysidp = insbdlysidp;
			this.createdon = Objects.requireNonNull(createdon, "`createdon` is required");
			this.createdby = Objects.requireNonNull(createdby, "`createdby` is required");
			this.modifyon = modifyon;
			this.modifyby = modifyby;
			this.lastoperation = Objects.requireNonNull(lastoperation, "`lastoperation` is required");
			this.insbddocuplodid = insbddocuplodid;
			this.insignbdntaxtrn = insignbdntaxtrn;
		}

		public Long getInsignbdndtlid() {
			return insignbdndtlid;
		}

		public Long getInsignbdnhdrid() {
			return insignbdnhdrid;
		}

		public Integer getInsbddocsrl() {
			return insbddocsrl;
		}

		public Long getInsbdpartyid() {
			return insbdpartyid;
		}

		public Long getInsbditemid() {
			return insbditemid;
		}

		public Short getInsbdqty() {
			return insbdqty;
		}

		public BigDecimal getInsbdrate() {
			return insbdrate;
		}

		public BigDecimal getInsbdvalue() {
			return insbdvalue;
		}

		public BigDecimal getInsbdtvalue() {
			return insbdtvalue;
		}

		public BigDecimal getInsbdnvalue() {
			return insbdnvalue;
		}

		public String getInsbdhocomm() {
			return insbdhocomm;
		}

		public Long getInsbdtaxcat() {
			return insbdtaxcat;
		}

		public BigDecimal getInsbdheight() {
			return insbdheight;
		}

		public BigDecimal getInsbdwidth() {
			return insbdwidth;
		}

		public BigDecimal getInsbdsqmt() {
			return insbdsqmt;
		}

		public String getInsbdremarks() {
			return insbdremarks;
		}

		public String getInsbdbdncust() {
			return insbdbdncust;
		}

		public BigDecimal getInsbdlysil() {
			return insbdlysil;
		}

		public BigDecimal getInsbdlysidp() {
			return insbdlysidp;
		}

		public Timestamp getCreatedon() {
			return createdon;
		}

		public Long getCreatedby() {
			return createdby;
		}

		public Timestamp getModifyon() {
			return modifyon;
		}

		public Long getModifyby() {
			return modifyby;
		}

		public String getLastoperation() {
			return lastoperation;
		}

		public Long getInsbddocuplodid() {
			return insbddocuplodid;
		}

		public List<InsignbdntaxtrnBody> getInsignbdntaxtrn() {
			return insignbdntaxtrn;
		}
	}

	@JsonInclude(Include.ALWAYS)
	@JsonIgnoreProperties(ignoreUnknown = true)
	@ApiModel(description = "A request body model used in POST requests to create a Insignbdntaxtrn entity")
	public static final class InsignbdntaxtrnBody {

		private @ApiModelProperty(required = false, value = "REST representation of the 'INSIGNBDNTAXTRNID_BODY' (Primary Key)") Long insignbdntaxtrnid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSIGNBDNDTLID_BODY' (required) (Size = 20)") Long insignbdndtlid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBTTSRNO_BODY' (required) (Size = 3)") Integer insbttsrno;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBTTTAXID_BODY' (required) (Size = 20)") Long insbtttaxid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBTTPER_BODY' (required) (Size = 7,4)") BigDecimal insbttper;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBTTAMT_BODY' (required) (Size = 17,4)") BigDecimal insbttamt;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'INSBTTBASEAMT_BODY' (required) (Size = 17,4)") BigDecimal insbttbaseamt;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTSEQ0_BODY' (Size = 2)") Integer insbttseq0;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTSEQ1_BODY' (Size = 2)") Integer insbttseq1;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTSEQ2_BODY' (Size = 2)") Integer insbttseq2;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTSEQ3_BODY' (Size = 2)") Integer insbttseq3;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTSEQ4_BODY' (Size = 2)") Integer insbttseq4;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTSEQ5_BODY' (Size = 2)") Integer insbttseq5;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTSEQ6_BODY' (Size = 2)") Integer insbttseq6;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTSEQ7_BODY' (Size = 2)") Integer insbttseq7;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTSEQ8_BODY' (Size = 2)") Integer insbttseq8;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTSEQ9_BODY' (Size = 2)") Integer insbttseq9;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTSEQ10_BODY' (Size = 2)") Integer insbttseq10;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTACCID_BODY' (Size = 20)") Long insbttaccid;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTEDITFLAG_BODY' (Size = 1)") String insbtteditflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'INSBTTADHOCFLAG_BODY' (Size = 1)") String insbttadhocflag;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'CREATEDON_BODY' (required)") Timestamp createdon;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'CREATEDBY_BODY' (required) (Size = 20)") Long createdby;
		private @ApiModelProperty(required = false, value = "REST representation of the 'MODIFYON_BODY'") Timestamp modifyon;
		private @ApiModelProperty(required = false, value = "REST representation of the 'MODIFYBY_BODY' (Size = 20)") Long modifyby;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'LASTOPERATION_BODY' (required) (Size = 10)") String lastoperation;

		@JsonCreator
		public InsignbdntaxtrnBody(
				@JsonProperty("insignbdntaxtrnid") Long insignbdntaxtrnid,
				@JsonProperty("insignbdndtlid") Long insignbdndtlid,
				@JsonProperty("insbttsrno") Integer insbttsrno,
				@JsonProperty("insbtttaxid") Long insbtttaxid,
				@JsonProperty("insbttper") BigDecimal insbttper,
				@JsonProperty("insbttamt") BigDecimal insbttamt,
				@JsonProperty("insbttbaseamt") BigDecimal insbttbaseamt,
				@JsonProperty("insbttseq0") Integer insbttseq0,
				@JsonProperty("insbttseq1") Integer insbttseq1,
				@JsonProperty("insbttseq2") Integer insbttseq2,
				@JsonProperty("insbttseq3") Integer insbttseq3,
				@JsonProperty("insbttseq4") Integer insbttseq4,
				@JsonProperty("insbttseq5") Integer insbttseq5,
				@JsonProperty("insbttseq6") Integer insbttseq6,
				@JsonProperty("insbttseq7") Integer insbttseq7,
				@JsonProperty("insbttseq8") Integer insbttseq8,
				@JsonProperty("insbttseq9") Integer insbttseq9,
				@JsonProperty("insbttseq10") Integer insbttseq10,
				@JsonProperty("insbttaccid") Long insbttaccid,
				@JsonProperty("insbtteditflag") String insbtteditflag,
				@JsonProperty("insbttadhocflag") String insbttadhocflag,
				@JsonProperty("createdon") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Timestamp createdon,
				@JsonProperty("createdby") Long createdby,
				@JsonProperty("modifyon") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Timestamp modifyon,
				@JsonProperty("modifyby") Long modifyby,
				@JsonProperty("lastoperation") String lastoperation) {
			this.insignbdntaxtrnid = Objects.requireNonNull(insignbdntaxtrnid, "`insignbdntaxtrnid` is required");
			this.insignbdndtlid = Objects.requireNonNull(insignbdndtlid, "`insignbdndtlid` is required");
			this.insbttsrno = Objects.requireNonNull(insbttsrno, "`insbttsrno` is required");
			this.insbtttaxid = Objects.requireNonNull(insbtttaxid, "`insbtttaxid` is required");
			this.insbttper = Objects.requireNonNull(insbttper, "`insbttper` is required");
			this.insbttamt = Objects.requireNonNull(insbttamt, "`insbttamt` is required");
			this.insbttbaseamt = Objects.requireNonNull(insbttbaseamt, "`insbttbaseamt` is required");
			this.insbttseq0 = insbttseq0;
			this.insbttseq1 = insbttseq1;
			this.insbttseq2 = insbttseq2;
			this.insbttseq3 = insbttseq3;
			this.insbttseq4 = insbttseq4;
			this.insbttseq5 = insbttseq5;
			this.insbttseq6 = insbttseq6;
			this.insbttseq7 = insbttseq7;
			this.insbttseq8 = insbttseq8;
			this.insbttseq9 = insbttseq9;
			this.insbttseq10 = insbttseq10;
			this.insbttaccid = insbttaccid;
			this.insbtteditflag = insbtteditflag;
			this.insbttadhocflag = insbttadhocflag;
			this.createdon = Objects.requireNonNull(createdon, "`createdon` is required");
			this.createdby = Objects.requireNonNull(createdby, "`createdby` is required");
			this.modifyon = modifyon;
			this.modifyby = modifyby;
			this.lastoperation = Objects.requireNonNull(lastoperation, "`lastoperation` is required");
		}

		public Long getInsignbdntaxtrnid() {
			return insignbdntaxtrnid;
		}

		public Long getInsignbdndtlid() {
			return insignbdndtlid;
		}

		public Integer getInsbttsrno() {
			return insbttsrno;
		}

		public Long getInsbtttaxid() {
			return insbtttaxid;
		}

		public BigDecimal getInsbttper() {
			return insbttper;
		}

		public BigDecimal getInsbttamt() {
			return insbttamt;
		}

		public BigDecimal getInsbttbaseamt() {
			return insbttbaseamt;
		}

		public Integer getInsbttseq0() {
			return insbttseq0;
		}

		public Integer getInsbttseq1() {
			return insbttseq1;
		}

		public Integer getInsbttseq2() {
			return insbttseq2;
		}

		public Integer getInsbttseq3() {
			return insbttseq3;
		}

		public Integer getInsbttseq4() {
			return insbttseq4;
		}

		public Integer getInsbttseq5() {
			return insbttseq5;
		}

		public Integer getInsbttseq6() {
			return insbttseq6;
		}

		public Integer getInsbttseq7() {
			return insbttseq7;
		}

		public Integer getInsbttseq8() {
			return insbttseq8;
		}

		public Integer getInsbttseq9() {
			return insbttseq9;
		}

		public Integer getInsbttseq10() {
			return insbttseq10;
		}

		public Long getInsbttaccid() {
			return insbttaccid;
		}

		public String getInsbtteditflag() {
			return insbtteditflag;
		}

		public String getInsbttadhocflag() {
			return insbttadhocflag;
		}

		public Timestamp getCreatedon() {
			return createdon;
		}

		public Long getCreatedby() {
			return createdby;
		}

		public Timestamp getModifyon() {
			return modifyon;
		}

		public Long getModifyby() {
			return modifyby;
		}

		public String getLastoperation() {
			return lastoperation;
		}
	}

}