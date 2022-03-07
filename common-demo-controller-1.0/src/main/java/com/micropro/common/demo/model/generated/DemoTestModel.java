package com.micropro.common.demo.model.generated;

import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class DemoTestModel {

	@JsonInclude(Include.ALWAYS)
	@JsonIgnoreProperties(ignoreUnknown = true)
	@ApiModel(description = "A request body model used in POST requests to create a Adaddmst entity")
	public static final class AdaddmstBody {

		private @ApiModelProperty(required = false, value = "REST representation of the 'ADADDMSTID_BODY' (Primary Key)") Long adaddmstid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'ADAMORGID_BODY' (required) (Size = 5)") Integer adamorgid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'ADAMOPRID_BODY' (required) (Size = 5)") Integer adamoprid;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMCONNAME_BODY' (Size = 50)") String adamconname;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMADD_BODY' (Size = 250)") String adamadd;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'ADAMCITY_BODY' (required) (Size = 20)") Long adamcity;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMTAHSILID_BODY' (Size = 20)") Long adamtahsilid;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADDMDISTRICTID_BODY' (Size = 20)") Long addmdistrictid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'ADDMSTATEID_BODY' (required) (Size = 20)") Long addmstateid;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'ADAMCOUNTRYID_BODY' (required) (Size = 20)") Long adamcountryid;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMPIN_BODY' (Size = 6)") String adampin;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMAREAID_BODY' (Size = 20)") Long adamareaid;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADDMPHONE_BODY' (Size = 100)") String addmphone;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMFAX_BODY' (Size = 50)") String adamfax;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMEMAIL_BODY' (Size = 100)") String adamemail;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'ADAMDEFUNCT_BODY' (required) (Size = 1)") String adamdefunct;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'CREATEDON_BODY' (required)") Date createdon;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'CREATEDBY_BODY' (required) (Size = 20)") Long createdby;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'MODIFYON_BODY' (required)") Date modifyon;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'MODIFYBY_BODY' (required) (Size = 20)") Long modifyby;
		private final @ApiModelProperty(required = true, value = "REST representation of the 'LASTOPERATION_BODY' (required) (Size = 10)") String lastoperation;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMADD2_BODY' (Size = 40)") String adamadd2;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMADD3_BODY' (Size = 40)") String adamadd3;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMNAMEPRINTFLAG_BODY' (Size = 1)") String adamnameprintflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMADD1PRINTFLAG_BODY' (Size = 1)") String adamadd1printflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMADD2PRINTFLAG_BODY' (Size = 1)") String adamadd2printflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMADD3PRINTFLAG_BODY' (Size = 1)") String adamadd3printflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMPINPRINTFLAG_BODY' (Size = 1)") String adampinprintflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMPHONEPRINTFLAG_BODY' (Size = 1)") String adamphoneprintflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMTYPE_BODY' (Size = 1)") String adamtype;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMCITYFLAG_BODY' (Size = 1)") String adamcityflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMSTATEFLAG_BODY' (Size = 1)") String adamstateflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMTAHSILFLAG_BODY' (Size = 1)") String adamtahsilflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMDISTRICTFLAG_BODY' (Size = 1)") String adamdistrictflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMAREAFLAG_BODY' (Size = 1)") String adamareaflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMFAXFLAG_BODY' (Size = 1)") String adamfaxflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMEMAILFLAG_BODY' (Size = 1)") String adamemailflag;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMMOBILENO_BODY' (Size = 15)") String adammobileno;
		private @ApiModelProperty(required = false, value = "REST representation of the 'ADAMMOBILEFLAG_BODY' (Size = 1)") String adammobileflag;

		@JsonCreator
		public AdaddmstBody(
				@JsonProperty("adaddmstid") Long adaddmstid,
				@JsonProperty("adamorgid") Integer adamorgid,
				@JsonProperty("adamoprid") Integer adamoprid,
				@JsonProperty("adamconname") String adamconname,
				@JsonProperty("adamadd") String adamadd,
				@JsonProperty("adamcity") Long adamcity,
				@JsonProperty("adamtahsilid") Long adamtahsilid,
				@JsonProperty("addmdistrictid") Long addmdistrictid,
				@JsonProperty("addmstateid") Long addmstateid,
				@JsonProperty("adamcountryid") Long adamcountryid,
				@JsonProperty("adampin") String adampin,
				@JsonProperty("adamareaid") Long adamareaid,
				@JsonProperty("addmphone") String addmphone,
				@JsonProperty("adamfax") String adamfax,
				@JsonProperty("adamemail") String adamemail,
				@JsonProperty("adamdefunct") String adamdefunct,
				@JsonProperty("createdon") @JsonFormat(pattern = "yyyy-MM-dd") Date createdon,
				@JsonProperty("createdby") Long createdby,
				@JsonProperty("modifyon") @JsonFormat(pattern = "yyyy-MM-dd") Date modifyon,
				@JsonProperty("modifyby") Long modifyby,
				@JsonProperty("lastoperation") String lastoperation,
				@JsonProperty("adamadd2") String adamadd2,
				@JsonProperty("adamadd3") String adamadd3,
				@JsonProperty("adamnameprintflag") String adamnameprintflag,
				@JsonProperty("adamadd1printflag") String adamadd1printflag,
				@JsonProperty("adamadd2printflag") String adamadd2printflag,
				@JsonProperty("adamadd3printflag") String adamadd3printflag,
				@JsonProperty("adampinprintflag") String adampinprintflag,
				@JsonProperty("adamphoneprintflag") String adamphoneprintflag,
				@JsonProperty("adamtype") String adamtype,
				@JsonProperty("adamcityflag") String adamcityflag,
				@JsonProperty("adamstateflag") String adamstateflag,
				@JsonProperty("adamtahsilflag") String adamtahsilflag,
				@JsonProperty("adamdistrictflag") String adamdistrictflag,
				@JsonProperty("adamareaflag") String adamareaflag,
				@JsonProperty("adamfaxflag") String adamfaxflag,
				@JsonProperty("adamemailflag") String adamemailflag,
				@JsonProperty("adammobileno") String adammobileno,
				@JsonProperty("adammobileflag") String adammobileflag) {
			this.adaddmstid = Objects.requireNonNull(adaddmstid, "`adaddmstid` is required");
			this.adamorgid = Objects.requireNonNull(adamorgid, "`adamorgid` is required");
			this.adamoprid = Objects.requireNonNull(adamoprid, "`adamoprid` is required");
			this.adamconname = adamconname;
			this.adamadd = adamadd;
			this.adamcity = Objects.requireNonNull(adamcity, "`adamcity` is required");
			this.adamtahsilid = adamtahsilid;
			this.addmdistrictid = addmdistrictid;
			this.addmstateid = Objects.requireNonNull(addmstateid, "`addmstateid` is required");
			this.adamcountryid = Objects.requireNonNull(adamcountryid, "`adamcountryid` is required");
			this.adampin = adampin;
			this.adamareaid = adamareaid;
			this.addmphone = addmphone;
			this.adamfax = adamfax;
			this.adamemail = adamemail;
			this.adamdefunct = Objects.requireNonNull(adamdefunct, "`adamdefunct` is required");
			this.createdon = Objects.requireNonNull(createdon, "`createdon` is required");
			this.createdby = Objects.requireNonNull(createdby, "`createdby` is required");
			this.modifyon = Objects.requireNonNull(modifyon, "`modifyon` is required");
			this.modifyby = Objects.requireNonNull(modifyby, "`modifyby` is required");
			this.lastoperation = Objects.requireNonNull(lastoperation, "`lastoperation` is required");
			this.adamadd2 = adamadd2;
			this.adamadd3 = adamadd3;
			this.adamnameprintflag = adamnameprintflag;
			this.adamadd1printflag = adamadd1printflag;
			this.adamadd2printflag = adamadd2printflag;
			this.adamadd3printflag = adamadd3printflag;
			this.adampinprintflag = adampinprintflag;
			this.adamphoneprintflag = adamphoneprintflag;
			this.adamtype = adamtype;
			this.adamcityflag = adamcityflag;
			this.adamstateflag = adamstateflag;
			this.adamtahsilflag = adamtahsilflag;
			this.adamdistrictflag = adamdistrictflag;
			this.adamareaflag = adamareaflag;
			this.adamfaxflag = adamfaxflag;
			this.adamemailflag = adamemailflag;
			this.adammobileno = adammobileno;
			this.adammobileflag = adammobileflag;
		}

		public Long getAdaddmstid() {
			return adaddmstid;
		}

		public Integer getAdamorgid() {
			return adamorgid;
		}

		public Integer getAdamoprid() {
			return adamoprid;
		}

		public String getAdamconname() {
			return adamconname;
		}

		public String getAdamadd() {
			return adamadd;
		}

		public Long getAdamcity() {
			return adamcity;
		}

		public Long getAdamtahsilid() {
			return adamtahsilid;
		}

		public Long getAddmdistrictid() {
			return addmdistrictid;
		}

		public Long getAddmstateid() {
			return addmstateid;
		}

		public Long getAdamcountryid() {
			return adamcountryid;
		}

		public String getAdampin() {
			return adampin;
		}

		public Long getAdamareaid() {
			return adamareaid;
		}

		public String getAddmphone() {
			return addmphone;
		}

		public String getAdamfax() {
			return adamfax;
		}

		public String getAdamemail() {
			return adamemail;
		}

		public String getAdamdefunct() {
			return adamdefunct;
		}

		public Date getCreatedon() {
			return createdon;
		}

		public Long getCreatedby() {
			return createdby;
		}

		public Date getModifyon() {
			return modifyon;
		}

		public Long getModifyby() {
			return modifyby;
		}

		public String getLastoperation() {
			return lastoperation;
		}

		public String getAdamadd2() {
			return adamadd2;
		}

		public String getAdamadd3() {
			return adamadd3;
		}

		public String getAdamnameprintflag() {
			return adamnameprintflag;
		}

		public String getAdamadd1printflag() {
			return adamadd1printflag;
		}

		public String getAdamadd2printflag() {
			return adamadd2printflag;
		}

		public String getAdamadd3printflag() {
			return adamadd3printflag;
		}

		public String getAdampinprintflag() {
			return adampinprintflag;
		}

		public String getAdamphoneprintflag() {
			return adamphoneprintflag;
		}

		public String getAdamtype() {
			return adamtype;
		}

		public String getAdamcityflag() {
			return adamcityflag;
		}

		public String getAdamstateflag() {
			return adamstateflag;
		}

		public String getAdamtahsilflag() {
			return adamtahsilflag;
		}

		public String getAdamdistrictflag() {
			return adamdistrictflag;
		}

		public String getAdamareaflag() {
			return adamareaflag;
		}

		public String getAdamfaxflag() {
			return adamfaxflag;
		}

		public String getAdamemailflag() {
			return adamemailflag;
		}

		public String getAdammobileno() {
			return adammobileno;
		}

		public String getAdammobileflag() {
			return adammobileflag;
		}
	}

}