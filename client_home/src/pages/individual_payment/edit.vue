<template>
	<view class="diy_edit page_individual_payment" id="individual_payment_edit">
		<view class='warp'>
			<view class='container'>
				<view class='row'>
						<view v-if="$check_field('set','insurance_name') || $check_field('add','insurance_name') || $check_field('get','insurance_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								保险名称:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_insurance_name" v-model="form['insurance_name']" placeholder="请输入保险名称" v-if="(form['insurance_name'] && $check_field('set','insurance_name')) || (!form['insurance_name'] && $check_field('add','insurance_name'))" :disabled="disabledObj['insurance_name_isDisabled']" />
							<text v-else-if="$check_field('get','insurance_name')">{{ form['insurance_name'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','insurance_type') || $check_field('add','insurance_type') || $check_field('get','insurance_type')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								保险类型:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_insurance_type" v-model="form['insurance_type']" placeholder="请输入保险类型" v-if="(form['insurance_type'] && $check_field('set','insurance_type')) || (!form['insurance_type'] && $check_field('add','insurance_type'))" :disabled="disabledObj['insurance_type_isDisabled']" />
							<text v-else-if="$check_field('get','insurance_type')">{{ form['insurance_type'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','insurance_price') || $check_field('add','insurance_price') || $check_field('get','insurance_price')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								保险价格:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_insurance_price" v-model="form['insurance_price']" placeholder="请输入保险价格" v-if="(form['insurance_price'] && $check_field('set','insurance_price')) || (!form['insurance_price'] && $check_field('add','insurance_price'))" :disabled="disabledObj['insurance_price_isDisabled']" />
							<text v-else-if="$check_field('get','insurance_price')">{{ form['insurance_price'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','purchasing_users') || $check_field('add','purchasing_users') || $check_field('get','purchasing_users')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								购买用户:
							</text>
						</view>
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_purchasing_users"
									v-model="form['purchasing_users']"
									:localdata="list_user_purchasing_users"
									:clear="!disabledObj['purchasing_users_isDisabled']"
									:disabled="disabledObj['purchasing_users_isDisabled']"
									v-if="(form['purchasing_users'] && $check_field('set','purchasing_users')) || (!form['purchasing_users'] && $check_field('add','purchasing_users'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','purchasing_users')">{{ form['purchasing_users'] }}</text>
						</view>
					</view>
							<view v-if="$check_field('set','user_name') || $check_field('add','user_name') || $check_field('get','user_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								用户姓名:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_user_name" v-model="form['user_name']" placeholder="请输入用户姓名" v-if="(form['user_name'] && $check_field('set','user_name')) || (!form['user_name'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']" />
							<text v-else-if="$check_field('get','user_name')">{{ form['user_name'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','purchase_date') || $check_field('add','purchase_date') || $check_field('get','purchase_date')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								购买日期:
							</text>
						</view>
								<!-- 日期 -->
						<view class="diy_field diy_date">
							<uni-datetime-picker :disabled="disabledObj['purchase_date_isDisabled']" type="date" id="form_purchase_date" v-model="form['purchase_date']" placeholder="请输入购买日期" v-if="(form['purchase_date'] && $check_field('set','purchase_date')) || (!form['purchase_date'] && $check_field('add','purchase_date'))" />
							<text v-else-if="$check_field('get','purchase_date')">{{ form['purchase_date'] }}</text>
						</view>
							</view>
							<view v-if="$check_field('set','remarks') || $check_field('add','remarks') || $check_field('get','remarks')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								备注信息:
							</text>
						</view>
								<!-- 多文本 -->
						<view class="diy_field diy_desc diy_text_row">
							<textarea id="form_remarks" v-model="form['remarks']" v-if="(form['remarks'] && $check_field('set','remarks')) || (!form['remarks'] && $check_field('add','remarks'))" :disabled="disabledObj['remarks_isDisabled']"/>
							<text v-else-if="$check_field('get','remarks')">{{ form['remarks'] }}</text>
						</view>
							</view>
	
				</view>
				<view class="row">
					<view class="col-12">
						<view class="btn_box">
							<button class="btn_submit primary_btn" @click="submit()">提交</button>
						</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
import mixin from "@/libs/mixins/page.js";
export default {
	mixins:[mixin],
	components:{},
	data(){
		return{
			url_get_obj:"~/api/individual_payment/get_obj?",
			url_add:"~/api/individual_payment/add?",
			url_set:"~/api/individual_payment/set?",

			// 登录权限
			oauth: {
				"signIn": true,
				"user_group": []
			},

			// 查询条件
			query: {
					"insurance_name": "",
						"insurance_type": "",
						"insurance_price": "",
						"purchasing_users": 0,
						"user_name": "",
						"purchase_date": "",
						"remarks": "",
					"individual_payment_id": 0
			},

			obj: {
					"insurance_name":  '', // 保险名称
						"insurance_type":  '', // 保险类型
						"insurance_price":  '', // 保险价格
						"purchasing_users": 0, // 购买用户
						"user_name":  '', // 用户姓名
						"purchase_date": this.$toTime(new Date().getTime(), "yyyy-MM-dd"),
						"remarks":  '', // 备注信息
					"individual_payment_id": 0,

			},

			// 表单字段
			form: {
					"insurance_name":  '', // 保险名称
						"insurance_type":  '', // 保险类型
						"insurance_price":  '', // 保险价格
						"purchasing_users": 0, // 购买用户
						"user_name":  '', // 用户姓名
						"purchase_date": this.$toTime(new Date().getTime(), "yyyy-MM-dd"),
						"remarks":  '', // 备注信息
					"individual_payment_id": 0,
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
							
			field:"individual_payment_id",
			table_key:"individual_payment",

		}
	},
	methods: {
			
	
				
	
				
	
					/**
		 * 获取老人家属用户列表
		 */
		async get_list_user_purchasing_users() {
			// if(this.user_group !== "管理员" && this.form["purchasing_users"] === 0) {
			//     this.form["purchasing_users"] = this.user.user_id;
			// }
			var json = await this.$get("~/api/user/get_list?user_group=老人家属");
			if(json.result && json.result.list){
				json.result.list.map((o) => this.list_user_purchasing_users.push({value:o.user_id,text:o.nickname + '-' + o.username}));
			}
			else if(json.error){
				console.error(json.error);
			}
		},
				async get_user_session_purchasing_users(){
			var _this = this;
			var json = await this.$get("~/api/user_group/get_obj?name=老人家属");
			if(json.result && json.result.obj){
				var source_table = json.result.obj.source_table;
				var user_id = _this.$store.state.user.user_id;
				if (user_id){
					var url = "~/api/"+source_table+"/get_obj?"
					this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
						if (res.result && res.result.obj) {
							var arr = []
							for (let key in res.result.obj) {
								arr.push(key)
							}
							var arrForm = []
							for (let key in _this.form) {
								arrForm.push(key)
							}
							_this.form["purchasing_users"] = user_id
							_this.disabledObj['purchasing_users' + '_isDisabled'] = true
							for (var i=0;i<arr.length;i++){
                if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                  for (var j = 0; j < arrForm.length; j++) {
                    if (arr[i] === arrForm[j]) {
                      if (arr[i] !== "purchasing_users") {
                        _this.form[arrForm[j]] = res.result.obj[arr[i]]
                        _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                        break;
                      }
                    }
                  }
                }
							}
						}
					});
				}
			}
			else if(json.error){
				console.error(json.error);
			}
		},
	
	
				
	
				
	
				
	
			change_file(key_name){
			var _self = this;
				this.$chooseFile().then(res=>{
					console.log(res)

						const uploadTask = uni.uploadFile({
							url: _self.$fullUrl("/api/feedback/upload?"),
							filePath: res[0].path,
							name: "file",
							formData: {
								i_want_to_customize: "test",
							},
							header: {
								"x-auth-token": _self.$store.state.user.token,
							},
							success: function(uploadFileRes) {
								console.log(uploadFileRes)
								var filename = JSON.parse(uploadFileRes.data).result.url;
								_self.form[key_name] = filename;
							},
						});

						uploadTask.onProgressUpdate(function(res) {
							_self.percent = res.progress;
							console.log("上传进度" + res.progress);
							console.log("已经上传的数据长度" + res.totalBytesSent);
							console.log(
								"预期需要上传的数据总长度" + res.totalBytesExpectedToSend
							);
						});

				})
		},
		change_img(key_name) {
			var _self = this;
			_self.upload_img_flag = false
			// 选择图像方法
			uni.chooseImage({
				count: 1,
				sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
				sourceType: ['album'], //从相册选择
				success: function(res) {
					const tempFilePaths = res.tempFilePaths;
					const uploadTask = uni.uploadFile({
						url: _self.$fullUrl('/api/individual_payment/upload?'),
						filePath: tempFilePaths[0],
						name: 'file',
						formData: {
							'individual_payment': 'test'
						},
						header: {
							'x-auth-token': _self.$store.state.user.token
						},
						success: function(uploadFileRes) {
							var filename = JSON.parse(uploadFileRes.data).result.url
							var img_url = filename
							_self.form[key_name] = img_url
						}
					});

					uploadTask.onProgressUpdate(function(res) {
						_self.percent = res.progress;
						console.log('上传进度' + res.progress);
						console.log('已经上传的数据长度' + res.totalBytesSent);
						console.log('预期需要上传的数据总长度' + res.totalBytesExpectedToSend);
					});
				},
				error: function(e) {
					console.log(e);
				}
			});
		},

		/**
		 * 获取对象后获取缓存表单
		 * @param {Object} json
		 * @param {Object} func
		 */
		get_obj_before(param){
			var form = uni.db.get("form");
			if (form) {
        delete(form.examine_state)
        delete(form.examine_reply)
				this.obj = uni.push(this.obj ,form);
				this.form = uni.push(this.form ,form);
			}
			var arr = []
			for (let key in form) {
				arr.push(key)
			}
			for (var i=0;i<arr.length;i++){
				this.disabledObj[arr[i] + '_isDisabled'] = true
			}
															if (this.form["purchase_date"] && JSON.stringify(this.form["purchase_date"]).indexOf("-")===-1) {
				this.form["purchase_date"] = this.$toTime(parseInt(this.form["purchase_date"]), "yyyy-MM-dd")
			}
						uni.db.del("form");
			return param;
		},

		/**
		 * 获取对象后获取缓存表单
		 * @param {Object} json
		 * @param {Object} func
		 */
		get_obj_after(json ,func){
			var form = uni.db.get("form");
			var obj = Object.assign({} ,form ,this.obj);
			if (form) {
				this.obj = uni.push(this.obj ,obj);
			}
			if (form) {
				this.form = uni.push(this.form ,form);
			}
			if(func){
				func(json);
			}
		},

	},
	onLoad(){
													this.get_user_session_purchasing_users();
				this.get_list_user_purchasing_users();
											},
}
</script>

<style scoped>
	input{
		font-size: 10px;
	}

	.form_edit {
		background-color: #fff;
		margin-bottom: 0.5rem;
		padding: 1rem;
		font-size: 10px;
	}

	.item {
		display: flex;
		padding: 0.2rem 0;
	}

	.left_text {
		flex: 0 0 25%;
		display: flex;
		align-items: center;
	}

	.right_text {
		flex: 0 0 75%;
		border-bottom: 1px solid #eee;
	}
	.right_text.btn_warp{
		border-bottom: 0;
	}

	.btn_submit {
		text-align: center;
		background-color: #fff;
		padding: 0.3rem;
		margin: 0.1rem 1rem;
		border: 1px solid #eee;
		border-radius: 0.5rem;
	}

	.btn_submit:hover {
		opacity: 0.5;
	}
	.btn_add_img{
		color: #D3D3D3;
		text-align: center;
		border: 1px solid #eee;
		height: 5rem;
		width: 5rem;
		position: relative;
	}
	.btn_add_img text{
		font-size: 35px;
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%,-50%);
	}




</style>
<style scoped>
/*新样式*/
.diy_text_row {
  display: inline-block;
}
.container {
	margin-top:1rem ;
	padding: 1rem;
    -webkit-box-shadow: 0px 0px 0px #888888;
    box-shadow: 0px 0px 0px #888888;
}
.primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
	.btn_submit{
		padding: 0;
		margin-top:1rem ;
	}
	.row-item {
		padding: 10px 10px;
	    background: #f8f6fc;
		margin-bottom: 1rem;
	}
	.diy_field{
		padding-left: 1rem;
	}
	.diy_title{
		align-items: center;
        font-size: 14px;
        color: #333;
	}

	.row-item{
		display: flex !important;
		align-items: baseline;
	}
	.diy_select_flex{
		flex: 1;
	}
	.query_select{
		flex: 1;
		border-color: rgb(229, 229, 229);
		background-color: rgb(255, 255, 255);
		border-radius: 4px;
		box-sizing: border-box;
		flex: 1;
		width: 100%;
		line-height: 2;
		font-size: 14px;
		height: 2.4em;
		min-height: 2.4em;
		display: block;
		outline:none;
	}
</style>

