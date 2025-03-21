<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单编号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单编号"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','order_number')) || (!form['appointment_order_id'] && $check_field('add','order_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','corporate_name') || $check_field('add','corporate_name') || $check_field('set','corporate_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="公司名称" prop="corporate_name">
												<el-input id="corporate_name" v-model="form['corporate_name']" placeholder="请输入公司名称"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','corporate_name')) || (!form['appointment_order_id'] && $check_field('add','corporate_name'))" :disabled="disabledObj['corporate_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','corporate_name')">{{form['corporate_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','service_name') || $check_field('add','service_name') || $check_field('set','service_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="服务名称" prop="service_name">
												<el-input id="service_name" v-model="form['service_name']" placeholder="请输入服务名称"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','service_name')) || (!form['appointment_order_id'] && $check_field('add','service_name'))" :disabled="disabledObj['service_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','service_name')">{{form['service_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','service_type') || $check_field('add','service_type') || $check_field('set','service_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="服务类型" prop="service_type">
												<el-input id="service_type" v-model="form['service_type']" placeholder="请输入服务类型"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','service_type')) || (!form['appointment_order_id'] && $check_field('add','service_type'))" :disabled="disabledObj['service_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','service_type')">{{form['service_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','service_price') || $check_field('add','service_price') || $check_field('set','service_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="服务价格" prop="service_price">
												<el-input id="service_price" v-model="form['service_price']" placeholder="请输入服务价格"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','service_price')) || (!form['appointment_order_id'] && $check_field('add','service_price'))" :disabled="disabledObj['service_price_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','service_price')">{{form['service_price']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','appointment_users') || $check_field('add','appointment_users') || $check_field('set','appointment_users')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="预约用户" prop="appointment_users">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_appointment_users(form['appointment_users']) }}
							<!--<el-input id="business_name" v-model="form['appointment_users']" placeholder="请输入预约用户"-->
							<!--v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','appointment_users')) || (!form['appointment_order_id'] && $check_field('add','appointment_users'))" :disabled="disabledObj['appointment_users_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','appointment_users')">{{form['appointment_users']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','appointment_users')) || (!form['appointment_order_id'] && $check_field('add','appointment_users'))" id="appointment_users" v-model="form['appointment_users']" :disabled="disabledObj['appointment_users_isDisabled']">
								<el-option v-for="o in list_user_appointment_users" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','appointment_users')" id="appointment_users" v-model="form['appointment_users']" :disabled="true">
								<el-option v-for="o in list_user_appointment_users" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="appointment_users" v-model="form['appointment_users']" :disabled="disabledObj['appointment_users_isDisabled']">
							<el-option v-for="o in list_user_appointment_users" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户姓名" prop="user_name">
												<el-input id="user_name" v-model="form['user_name']" placeholder="请输入用户姓名"
							  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','user_name')) || (!form['appointment_order_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','elderly_users') || $check_field('add','elderly_users') || $check_field('set','elderly_users')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="老人用户" prop="elderly_users">
													<el-select v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','elderly_users')) || (!form['appointment_order_id'] && $check_field('add','elderly_users'))" id="elderly_users" v-model="form['elderly_users']" :disabled="disabledObj['elderly_users_isDisabled']">
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
								<el-col v-if="user_group === '管理员' || $check_field('get','time_of_appointment') || $check_field('add','time_of_appointment') || $check_field('set','time_of_appointment')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="预约时间" prop="time_of_appointment">
								<el-date-picker :disabled="disabledObj['time_of_appointment_isDisabled']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','time_of_appointment')) || (!form['appointment_order_id'] && $check_field('add','time_of_appointment'))" id="time_of_appointment"
						v-model="form['time_of_appointment']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','time_of_appointment')">{{form['time_of_appointment']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','appointment_notes') || $check_field('add','appointment_notes') || $check_field('set','appointment_notes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="预约备注" prop="appointment_notes">
								<el-input type="textarea" id="appointment_notes" v-model="form['appointment_notes']" placeholder="请输入预约备注"
						v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','appointment_notes')) || (!form['appointment_order_id'] && $check_field('add','appointment_notes'))" :disabled="disabledObj['appointment_notes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','appointment_notes')">{{form['appointment_notes']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_status') || $check_field('add','order_status') || $check_field('set','order_status')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单状态" prop="order_status">
								<el-select id="order_status" v-model="form['order_status']"
						v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','order_status')) || (!form['appointment_order_id'] && $check_field('add','order_status'))">
						<el-option v-for="o in list_order_status" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','order_status')">{{form['order_status']}}</div>
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
				field: "appointment_order_id",
				url_add: "~/api/appointment_order/add?",
				url_set: "~/api/appointment_order/set?",
				url_get_obj: "~/api/appointment_order/get_obj?",
				url_upload: "~/api/appointment_order/upload?",

				query: {
					"appointment_order_id": 0,
				},

				form: {
								"order_number": this.$get_stamp(), // 订单编号
										"corporate_name":  '', // 公司名称
										"service_name":  '', // 服务名称
										"service_type":  '', // 服务类型
										"service_price":  '', // 服务价格
										"appointment_users": 0, // 预约用户
										"user_name":  '', // 用户姓名
										"elderly_users": 0, // 老人用户
										"time_of_appointment":  '', // 预约时间
										"appointment_notes":  '', // 预约备注
										"order_status":  '', // 订单状态
											"appointment_order_id": 0, // ID
						
				},
				disabledObj:{
								"order_number_isDisabled": false,
										"corporate_name_isDisabled": false,
										"service_name_isDisabled": false,
										"service_type_isDisabled": false,
										"service_price_isDisabled": false,
										"appointment_users_isDisabled": false,
										"user_name_isDisabled": false,
										"elderly_users_isDisabled": false,
										"time_of_appointment_isDisabled": false,
										"appointment_notes_isDisabled": false,
										"order_status_isDisabled": false,
										},

	
		
		
		
		
		
					// 用户列表
				list_user_appointment_users: [],
						// 用户组
				group_user_appointment_users: "",
				
		
					// 用户列表
				list_user_elderly_users: [],
				
		
						// 订单状态选项列表
				list_order_status: ['未通过','已通过'],
	
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
	
				/**
			 * 获取老人家属用户列表
			 */
			async get_list_user_appointment_users() {
                // if(this.user_group !== "管理员" && this.form["appointment_users"] === 0) {
                //     this.form["appointment_users"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=老人家属");
                if(json.result && json.result.list){
                    this.list_user_appointment_users = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取老人家属用户组
			 */
			async get_group_user_appointment_users() {
							this.form["appointment_users"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=老人家属");
				if(json.result && json.result.obj){
					this.group_user_appointment_users = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_appointment_users(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_appointment_users.source_table+"/get_obj?"
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
												_this.form["appointment_users"] = id
									_this.disabledObj['appointment_users' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "appointment_users") {
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
					get_user_appointment_users(id){
				var obj = this.list_user_appointment_users.getObj({"user_id":id});
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
																	        if (this.form["time_of_appointment"].indexOf("-")===-1){
            this.form["time_of_appointment"] = this.$toTime(parseInt(this.form["time_of_appointment"]),"yyyy-MM-dd hh:mm:ss")
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


																									        if(this.form["time_of_appointment"]=="0000-00-00 00:00:00"){
          this.form["time_of_appointment"] = null;
        }
				if(parseInt(this.form["time_of_appointment"]) > 9999){
					this.form["time_of_appointment"] = this.$toTime(parseInt(this.form["time_of_appointment"]),"yyyy-MM-dd hh:mm:ss")
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
					bl = this.$check_action('/appointment_order/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_order/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_order/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_order/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/appointment_order/view','get');
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
															this.get_list_user_appointment_users();
					this.get_group_user_appointment_users();
										this.get_list_user_elderly_users();
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
