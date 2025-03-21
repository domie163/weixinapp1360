<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','elderly_users') || $check_field('add','elderly_users') || $check_field('set','elderly_users')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="老人用户" prop="elderly_users">
													<el-select v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','elderly_users')) || (!form['elderly_information_id'] && $check_field('add','elderly_users'))" id="elderly_users" v-model="form['elderly_users']" :disabled="disabledObj['elderly_users_isDisabled']">
							<el-option v-for="o in list_user_elderly_users" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','elderly_users')" id="elderly_users" v-model="form['elderly_users']" :disabled="true">
							<el-option v-for="o in list_user_elderly_users" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','family_members_of_the_elderly') || $check_field('add','family_members_of_the_elderly') || $check_field('set','family_members_of_the_elderly')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="老人家属" prop="family_members_of_the_elderly">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_family_members_of_the_elderly(form['family_members_of_the_elderly']) }}
							<!--<el-input id="business_name" v-model="form['family_members_of_the_elderly']" placeholder="请输入老人家属"-->
							<!--v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','family_members_of_the_elderly')) || (!form['elderly_information_id'] && $check_field('add','family_members_of_the_elderly'))" :disabled="disabledObj['family_members_of_the_elderly_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','family_members_of_the_elderly')">{{form['family_members_of_the_elderly']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','family_members_of_the_elderly')) || (!form['elderly_information_id'] && $check_field('add','family_members_of_the_elderly'))" id="family_members_of_the_elderly" v-model="form['family_members_of_the_elderly']" :disabled="disabledObj['family_members_of_the_elderly_isDisabled']">
								<el-option v-for="o in list_user_family_members_of_the_elderly" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','family_members_of_the_elderly')" id="family_members_of_the_elderly" v-model="form['family_members_of_the_elderly']" :disabled="true">
								<el-option v-for="o in list_user_family_members_of_the_elderly" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="family_members_of_the_elderly" v-model="form['family_members_of_the_elderly']" :disabled="disabledObj['family_members_of_the_elderly_isDisabled']">
							<el-option v-for="o in list_user_family_members_of_the_elderly" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
												<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','full_name')) || (!form['elderly_information_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','gender') || $check_field('add','gender') || $check_field('set','gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="性别" prop="gender">
								<el-select id="gender" v-model="form['gender']"
						v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','gender')) || (!form['elderly_information_id'] && $check_field('add','gender'))">
						<el-option v-for="o in list_gender" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','gender')">{{form['gender']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','age') || $check_field('add','age') || $check_field('set','age')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年龄" prop="age">
												<el-input id="age" v-model="form['age']" placeholder="请输入年龄"
							  v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','age')) || (!form['elderly_information_id'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','age')">{{form['age']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','id_number') || $check_field('add','id_number') || $check_field('set','id_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份证号" prop="id_number">
												<el-input id="id_number" v-model="form['id_number']" placeholder="请输入身份证号"
							  v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','id_number')) || (!form['elderly_information_id'] && $check_field('add','id_number'))" :disabled="disabledObj['id_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','id_number')">{{form['id_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','contact_information') || $check_field('add','contact_information') || $check_field('set','contact_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系方式" prop="contact_information">
												<el-input id="contact_information" v-model="form['contact_information']" placeholder="请输入联系方式"
							  v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','contact_information')) || (!form['elderly_information_id'] && $check_field('add','contact_information'))" :disabled="disabledObj['contact_information_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_information')">{{form['contact_information']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','home_address') || $check_field('add','home_address') || $check_field('set','home_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="家庭住址" prop="home_address">
												<el-input id="home_address" v-model="form['home_address']" placeholder="请输入家庭住址"
							  v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','home_address')) || (!form['elderly_information_id'] && $check_field('add','home_address'))" :disabled="disabledObj['home_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','home_address')">{{form['home_address']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','remarks') || $check_field('add','remarks') || $check_field('set','remarks')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="备注信息" prop="remarks">
								<el-input type="textarea" id="remarks" v-model="form['remarks']" placeholder="请输入备注信息"
						v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','remarks')) || (!form['elderly_information_id'] && $check_field('add','remarks'))" :disabled="disabledObj['remarks_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','remarks')">{{form['remarks']}}</div>
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
				field: "elderly_information_id",
				url_add: "~/api/elderly_information/add?",
				url_set: "~/api/elderly_information/set?",
				url_get_obj: "~/api/elderly_information/get_obj?",
				url_upload: "~/api/elderly_information/upload?",

				query: {
					"elderly_information_id": 0,
				},

				form: {
								"elderly_users": 0, // 老人用户
										"family_members_of_the_elderly": 0, // 老人家属
										"full_name":  '', // 姓名
										"gender":  '', // 性别
										"age":  '', // 年龄
										"id_number":  '', // 身份证号
										"contact_information":  '', // 联系方式
										"home_address":  '', // 家庭住址
										"remarks":  '', // 备注信息
											"elderly_information_id": 0, // ID
						
				},
				disabledObj:{
								"elderly_users_isDisabled": false,
										"family_members_of_the_elderly_isDisabled": false,
										"full_name_isDisabled": false,
										"gender_isDisabled": false,
										"age_isDisabled": false,
										"id_number_isDisabled": false,
										"contact_information_isDisabled": false,
										"home_address_isDisabled": false,
										"remarks_isDisabled": false,
										},

	
					// 用户列表
				list_user_elderly_users: [],
				
					// 用户列表
				list_user_family_members_of_the_elderly: [],
						// 用户组
				group_user_family_members_of_the_elderly: "",
				
						// 性别选项列表
				list_gender: ['男','女'],
	
		
		
		
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取老人用户用户列表
			 */
			async get_list_user_elderly_users() {
                // if(this.user_group !== "管理员" && this.form["elderly_users"] === 0) {
                //     this.form["elderly_users"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=老人用户");
                if(json.result && json.result.list){
                    this.list_user_elderly_users = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_elderly_users(id){
				var obj = this.list_user_elderly_users.getObj({"user_id":id});
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
			 * 获取老人家属用户列表
			 */
			async get_list_user_family_members_of_the_elderly() {
                // if(this.user_group !== "管理员" && this.form["family_members_of_the_elderly"] === 0) {
                //     this.form["family_members_of_the_elderly"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=老人家属");
                if(json.result && json.result.list){
                    this.list_user_family_members_of_the_elderly = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取老人家属用户组
			 */
			async get_group_user_family_members_of_the_elderly() {
							this.form["family_members_of_the_elderly"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=老人家属");
				if(json.result && json.result.obj){
					this.group_user_family_members_of_the_elderly = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_family_members_of_the_elderly(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_family_members_of_the_elderly.source_table+"/get_obj?"
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
												_this.form["family_members_of_the_elderly"] = id
									_this.disabledObj['family_members_of_the_elderly' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "family_members_of_the_elderly") {
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
					get_user_family_members_of_the_elderly(id){
				var obj = this.list_user_family_members_of_the_elderly.getObj({"user_id":id});
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
					bl = this.$check_action('/elderly_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/elderly_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/elderly_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/elderly_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/elderly_information/view','get');
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
					this.get_list_user_elderly_users();
								this.get_list_user_family_members_of_the_elderly();
					this.get_group_user_family_members_of_the_elderly();
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
