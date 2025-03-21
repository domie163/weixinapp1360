<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','insurance_name') || $check_field('add','insurance_name') || $check_field('set','insurance_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="保险名称" prop="insurance_name">
												<el-input id="insurance_name" v-model="form['insurance_name']" placeholder="请输入保险名称"
							  v-if="user_group === '管理员' || (form['endowment_insurance_id'] && $check_field('set','insurance_name')) || (!form['endowment_insurance_id'] && $check_field('add','insurance_name'))" :disabled="disabledObj['insurance_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','insurance_name')">{{form['insurance_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','insurance_type') || $check_field('add','insurance_type') || $check_field('set','insurance_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="保险类型" prop="insurance_type">
												<el-input id="insurance_type" v-model="form['insurance_type']" placeholder="请输入保险类型"
							  v-if="user_group === '管理员' || (form['endowment_insurance_id'] && $check_field('set','insurance_type')) || (!form['endowment_insurance_id'] && $check_field('add','insurance_type'))" :disabled="disabledObj['insurance_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','insurance_type')">{{form['insurance_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','cover_photo') || $check_field('add','cover_photo') || $check_field('set','cover_photo')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="封面图片" prop="cover_photo">
								<el-upload :disabled="disabledObj['cover_photo_isDisabled']" id="cover_photo" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_cover_photo"
						:show-file-list="false" v-if="user_group === '管理员' || (form['endowment_insurance_id'] && $check_field('set','cover_photo')) || (!form['endowment_insurance_id'] && $check_field('add','cover_photo'))">
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
								<el-col v-if="user_group === '管理员' || $check_field('get','insurance_price') || $check_field('add','insurance_price') || $check_field('set','insurance_price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="保险价格" prop="insurance_price">
												<el-input id="insurance_price" v-model="form['insurance_price']" placeholder="请输入保险价格"
							  v-if="user_group === '管理员' || (form['endowment_insurance_id'] && $check_field('set','insurance_price')) || (!form['endowment_insurance_id'] && $check_field('add','insurance_price'))" :disabled="disabledObj['insurance_price_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','insurance_price')">{{form['insurance_price']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','insurance_details') || $check_field('add','insurance_details') || $check_field('set','insurance_details')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="保险详情" prop="insurance_details">
								<el-input type="textarea" id="insurance_details" v-model="form['insurance_details']" placeholder="请输入保险详情"
						v-if="user_group === '管理员' || (form['endowment_insurance_id'] && $check_field('set','insurance_details')) || (!form['endowment_insurance_id'] && $check_field('add','insurance_details'))" :disabled="disabledObj['insurance_details_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','insurance_details')">{{form['insurance_details']}}</div>
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
				field: "endowment_insurance_id",
				url_add: "~/api/endowment_insurance/add?",
				url_set: "~/api/endowment_insurance/set?",
				url_get_obj: "~/api/endowment_insurance/get_obj?",
				url_upload: "~/api/endowment_insurance/upload?",

				query: {
					"endowment_insurance_id": 0,
				},

				form: {
								"insurance_name":  '', // 保险名称
										"insurance_type":  '', // 保险类型
										"cover_photo":  '', // 封面图片
										"insurance_price":  '', // 保险价格
										"insurance_details":  '', // 保险详情
											"endowment_insurance_id": 0, // ID
						
				},
				disabledObj:{
								"insurance_name_isDisabled": false,
										"insurance_type_isDisabled": false,
										"cover_photo_isDisabled": false,
										"insurance_price_isDisabled": false,
										"insurance_details_isDisabled": false,
										},

	
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
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
					bl = this.$check_action('/endowment_insurance/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/endowment_insurance/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/endowment_insurance/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/endowment_insurance/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/endowment_insurance/view','get');
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
