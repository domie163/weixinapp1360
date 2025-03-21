<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','service_provider') || $check_field('add','service_provider') || $check_field('set','service_provider')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="服务商" prop="service_provider">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_service_provider(form['service_provider']) }}
							<!--<el-input id="business_name" v-model="form['service_provider']" placeholder="请输入服务商"-->
							<!--v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','service_provider')) || (!form['life_services_id'] && $check_field('add','service_provider'))" :disabled="disabledObj['service_provider_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','service_provider')">{{form['service_provider']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','service_provider')) || (!form['life_services_id'] && $check_field('add','service_provider'))" id="service_provider" v-model="form['service_provider']" :disabled="disabledObj['service_provider_isDisabled']">
								<el-option v-for="o in list_user_service_provider" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','service_provider')" id="service_provider" v-model="form['service_provider']" :disabled="true">
								<el-option v-for="o in list_user_service_provider" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="service_provider" v-model="form['service_provider']" :disabled="disabledObj['service_provider_isDisabled']">
							<el-option v-for="o in list_user_service_provider" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','corporate_name') || $check_field('add','corporate_name') || $check_field('set','corporate_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="公司名称" prop="corporate_name">
												<el-input id="corporate_name" v-model="form['corporate_name']" placeholder="请输入公司名称"
							  v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','corporate_name')) || (!form['life_services_id'] && $check_field('add','corporate_name'))" :disabled="disabledObj['corporate_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','corporate_name')">{{form['corporate_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','service_name') || $check_field('add','service_name') || $check_field('set','service_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="服务名称" prop="service_name">
												<el-input id="service_name" v-model="form['service_name']" placeholder="请输入服务名称"
							  v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','service_name')) || (!form['life_services_id'] && $check_field('add','service_name'))" :disabled="disabledObj['service_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','service_name')">{{form['service_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','service_type') || $check_field('add','service_type') || $check_field('set','service_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="服务类型" prop="service_type">
								<el-select id="service_type" v-model="form['service_type']"
						v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','service_type')) || (!form['life_services_id'] && $check_field('add','service_type'))">
						<el-option v-for="o in list_service_type" :key="o['service_type']" :label="o['service_type']"
							:value="o['service_type']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','service_type')">{{form['service_type']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','cover_photo') || $check_field('add','cover_photo') || $check_field('set','cover_photo')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="封面图片" prop="cover_photo">
								<el-upload :disabled="disabledObj['cover_photo_isDisabled']" id="cover_photo" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_cover_photo"
						:show-file-list="false" v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','cover_photo')) || (!form['life_services_id'] && $check_field('add','cover_photo'))">
						<img v-if="form['cover_photo']" :src="$fullUrl(form['cover_photo'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','cover_photo')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['cover_photo'])" :preview-src-list="[$fullUrl(form['cover_photo'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','service_price') || $check_field('add','service_price') || $check_field('set','service_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="服务价格" prop="service_price">
												<el-input id="service_price" v-model="form['service_price']" placeholder="请输入服务价格"
							  v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','service_price')) || (!form['life_services_id'] && $check_field('add','service_price'))" :disabled="disabledObj['service_price_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','service_price')">{{form['service_price']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','service_details') || $check_field('add','service_details') || $check_field('set','service_details')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="服务详情" prop="service_details">
								<el-input type="textarea" id="service_details" v-model="form['service_details']" placeholder="请输入服务详情"
						v-if="user_group === '管理员' || (form['life_services_id'] && $check_field('set','service_details')) || (!form['life_services_id'] && $check_field('add','service_details'))" :disabled="disabledObj['service_details_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','service_details')">{{form['service_details']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "life_services_id",
				url_add: "~/api/life_services/add?",
				url_set: "~/api/life_services/set?",
				url_get_obj: "~/api/life_services/get_obj?",
				url_upload: "~/api/life_services/upload?",

				query: {
					"life_services_id": 0,
				},

				form: {
								"service_provider": 0, // 服务商
										"corporate_name":  '', // 公司名称
										"service_name":  '', // 服务名称
										"service_type":  '', // 服务类型
										"cover_photo":  '', // 封面图片
										"service_price":  '', // 服务价格
										"service_details":  '', // 服务详情
											"life_services_id": 0, // ID
						
				},
				disabledObj:{
								"service_provider_isDisabled": false,
										"corporate_name_isDisabled": false,
										"service_name_isDisabled": false,
										"service_type_isDisabled": false,
										"cover_photo_isDisabled": false,
										"service_price_isDisabled": false,
										"service_details_isDisabled": false,
										},

	
					// 用户列表
				list_user_service_provider: [],
						// 用户组
				group_user_service_provider: "",
				
		
						// 服务类型选项列表
				list_service_type: [""],
	
		
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取服务商用户列表
			 */
			async get_list_user_service_provider() {
                // if(this.user_group !== "管理员" && this.form["service_provider"] === 0) {
                //     this.form["service_provider"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=服务商");
                if(json.result && json.result.list){
                    this.list_user_service_provider = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取服务商用户组
			 */
			async get_group_user_service_provider() {
							this.form["service_provider"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=服务商");
				if(json.result && json.result.obj){
					this.group_user_service_provider = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_service_provider(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_service_provider.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["service_provider"] = id
									_this.disabledObj['service_provider' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "service_provider") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_service_provider(id){
				var obj = this.list_user_service_provider.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
				/**
			 * 获取服务类型列表
			 */
			async get_list_service_type() {
				var json = await this.$get("~/api/service_classification/get_list?");
				if(json.result && json.result.list){
					this.list_service_type = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
						/**
			 * 上传封面图片
			 * @param {Object} param 图片参数
			 */
			upload_cover_photo(param){
						this.uploadFile(param.file, "cover_photo");
					},
	
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																			
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																		$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																					


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																											return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/life_services/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/life_services/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/life_services/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/life_services/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/life_services/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
					this.get_list_user_service_provider();
					this.get_group_user_service_provider();
											this.get_list_service_type();
										},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
