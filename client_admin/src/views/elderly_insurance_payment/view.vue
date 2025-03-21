<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','insurance_name') || $check_field('add','insurance_name') || $check_field('set','insurance_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="保险名称" prop="insurance_name">
												<el-input id="insurance_name" v-model="form['insurance_name']" placeholder="请输入保险名称"
							  v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','insurance_name')) || (!form['elderly_insurance_payment_id'] && $check_field('add','insurance_name'))" :disabled="disabledObj['insurance_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','insurance_name')">{{form['insurance_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','insurance_type') || $check_field('add','insurance_type') || $check_field('set','insurance_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="保险类型" prop="insurance_type">
												<el-input id="insurance_type" v-model="form['insurance_type']" placeholder="请输入保险类型"
							  v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','insurance_type')) || (!form['elderly_insurance_payment_id'] && $check_field('add','insurance_type'))" :disabled="disabledObj['insurance_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','insurance_type')">{{form['insurance_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','insurance_price') || $check_field('add','insurance_price') || $check_field('set','insurance_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="保险价格" prop="insurance_price">
												<el-input id="insurance_price" v-model="form['insurance_price']" placeholder="请输入保险价格"
							  v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','insurance_price')) || (!form['elderly_insurance_payment_id'] && $check_field('add','insurance_price'))" :disabled="disabledObj['insurance_price_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','insurance_price')">{{form['insurance_price']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','purchasing_users') || $check_field('add','purchasing_users') || $check_field('set','purchasing_users')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="购买用户" prop="purchasing_users">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_purchasing_users(form['purchasing_users']) }}
							<!--<el-input id="business_name" v-model="form['purchasing_users']" placeholder="请输入购买用户"-->
							<!--v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','purchasing_users')) || (!form['elderly_insurance_payment_id'] && $check_field('add','purchasing_users'))" :disabled="disabledObj['purchasing_users_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','purchasing_users')">{{form['purchasing_users']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','purchasing_users')) || (!form['elderly_insurance_payment_id'] && $check_field('add','purchasing_users'))" id="purchasing_users" v-model="form['purchasing_users']" :disabled="disabledObj['purchasing_users_isDisabled']">
								<el-option v-for="o in list_user_purchasing_users" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','purchasing_users')" id="purchasing_users" v-model="form['purchasing_users']" :disabled="true">
								<el-option v-for="o in list_user_purchasing_users" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="purchasing_users" v-model="form['purchasing_users']" :disabled="disabledObj['purchasing_users_isDisabled']">
							<el-option v-for="o in list_user_purchasing_users" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户姓名" prop="user_name">
												<el-input id="user_name" v-model="form['user_name']" placeholder="请输入用户姓名"
							  v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','user_name')) || (!form['elderly_insurance_payment_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','purchase_date') || $check_field('add','purchase_date') || $check_field('set','purchase_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="购买日期" prop="purchase_date">
								<el-date-picker :disabled="disabledObj['purchase_date_isDisabled']" v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','purchase_date')) || (!form['elderly_insurance_payment_id'] && $check_field('add','purchase_date'))" id="purchase_date"
						v-model="form['purchase_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','purchase_date')">{{form['purchase_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','remarks') || $check_field('add','remarks') || $check_field('set','remarks')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="备注信息" prop="remarks">
								<el-input type="textarea" id="remarks" v-model="form['remarks']" placeholder="请输入备注信息"
						v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','remarks')) || (!form['elderly_insurance_payment_id'] && $check_field('add','remarks'))" :disabled="disabledObj['remarks_isDisabled']"></el-input>
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
				field: "elderly_insurance_payment_id",
				url_add: "~/api/elderly_insurance_payment/add?",
				url_set: "~/api/elderly_insurance_payment/set?",
				url_get_obj: "~/api/elderly_insurance_payment/get_obj?",
				url_upload: "~/api/elderly_insurance_payment/upload?",

				query: {
					"elderly_insurance_payment_id": 0,
				},

				form: {
								"insurance_name":  '', // 保险名称
										"insurance_type":  '', // 保险类型
										"insurance_price":  '', // 保险价格
										"purchasing_users": 0, // 购买用户
										"user_name":  '', // 用户姓名
										"purchase_date":  '', // 购买日期
										"remarks":  '', // 备注信息
											"elderly_insurance_payment_id": 0, // ID
						
				},
				disabledObj:{
								"insurance_name_isDisabled": false,
										"insurance_type_isDisabled": false,
										"insurance_price_isDisabled": false,
										"purchasing_users_isDisabled": false,
										"user_name_isDisabled": false,
										"purchase_date_isDisabled": false,
										"remarks_isDisabled": false,
										},

	
		
		
		
					// 用户列表
				list_user_purchasing_users: [],
						// 用户组
				group_user_purchasing_users: "",
				
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
				/**
			 * 获取老人用户用户列表
			 */
			async get_list_user_purchasing_users() {
                // if(this.user_group !== "管理员" && this.form["purchasing_users"] === 0) {
                //     this.form["purchasing_users"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=老人用户");
                if(json.result && json.result.list){
                    this.list_user_purchasing_users = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取老人用户用户组
			 */
			async get_group_user_purchasing_users() {
							this.form["purchasing_users"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=老人用户");
				if(json.result && json.result.obj){
					this.group_user_purchasing_users = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_purchasing_users(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_purchasing_users.source_table+"/get_obj?"
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
												_this.form["purchasing_users"] = id
									_this.disabledObj['purchasing_users' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "purchasing_users") {
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
					get_user_purchasing_users(id){
				var obj = this.list_user_purchasing_users.getObj({"user_id":id});
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
											// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
																	
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
												        if (this.form["purchase_date"].indexOf("-")===-1){
          this.form["purchase_date"] = this.$toTime(parseInt(this.form["purchase_date"]),"yyyy-MM-dd")
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


																	        if(this.form["purchase_date"]=="0000-00-00"){
          this.form["purchase_date"] = null;
        }
				if(parseInt(this.form["purchase_date"]) > 9999){
					this.form["purchase_date"] = this.$toTime(parseInt(this.form["purchase_date"]),"yyyy-MM-dd")
				}
					


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
					bl = this.$check_action('/elderly_insurance_payment/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/elderly_insurance_payment/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/elderly_insurance_payment/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/elderly_insurance_payment/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/elderly_insurance_payment/view','get');
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
											this.get_list_user_purchasing_users();
					this.get_group_user_purchasing_users();
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
