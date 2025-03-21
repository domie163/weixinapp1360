<template>
	<view class="diy_details diy_div_elderly_information">
		<view v-if="Object.keys(obj).length!==0" class="warp">
			<view class="container">
				<view class="row">
					<view v-if="$check_field('get','elderly_users')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>老人用户:</span>
						</view>
							<view class="diy_field diy_uid">
							<text>
								{{ get_user_elderly_users(obj['elderly_users']) }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','family_members_of_the_elderly')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>老人家属:</span>
						</view>
							<view class="diy_field diy_uid">
							<text>
								{{ get_user_family_members_of_the_elderly(obj['family_members_of_the_elderly']) }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','full_name')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>姓名:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["full_name"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','gender')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>性别:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["gender"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','age')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>年龄:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["age"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','id_number')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>身份证号:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["id_number"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','contact_information')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>联系方式:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["contact_information"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','home_address')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>家庭住址:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["home_address"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','remarks')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>备注信息:</span>
						</view>
							<view class="diy_field diy_desc">
							<text>
								{{ obj["remarks"] }}
							</text>
						</view>
						</view>
				</view>
			</view>
		</view>

	</view>
</template>

<script>
	import mixin from "@/libs/mixins/component.js";
	export default {
		mixins: [mixin],
		props: {
			obj_goods: {
				type: Object,
				default(){
					return {}
				}
			},
			query:{
				type: Object,
				default(){
					return {
						elderly_information_id: 0
					}
				}
			}
		},
		data() {
			return {
				obj_goods_type: {},
				obj: {},
					// 用户列表
				list_user_elderly_users: [],
						// 用户列表
				list_user_family_members_of_the_elderly: [],
											}
		},
		methods: {
			async get_obj_goods_type() {
				var res = await this.$get("~/api/goods_type/get_obj", {
					name: this.obj_goods.type
				})

				if (res.result.obj) {
					this.obj_goods_type = res.result.obj
				} else {
					console.log("没有请求到商品分类");
				}
			},
			async get_obj_by_goods() {
				var {
					source_table,
					source_field
				} = this.obj_goods_type
				var {
					source_id
				} = this.obj_goods
				var query = {}
				query[source_field] = source_id
				this.$get("~/api/" + source_table + "/get_obj", {}, (res) => {
					if (res.result.obj) {
						this.obj = res.result.obj
					} else {
						console.log("没有请求到商品分类");
					}
				})
			},
			async get_obj_by_id(){
				var res = await this.$get("~/api/elderly_information/get_obj", {
					elderly_information_id:this.query.elderly_information_id
				})

				if (res.result && res.result.obj) {
					this.obj = res.result.obj
				} else {
					console.log("没有请求到商品分类");
				}
			},
				/**
			 * 获取老人用户用户列表
			 */
			async get_list_user_elderly_users() {
				var json = await this.$get("~/api/user/get_list?user_group=老人用户");
				if(json.result && json.result.list){
					this.list_user_elderly_users = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_elderly_users(id){
				let obj = this.list_user_elderly_users;
				let ret = "";
				for(let i=0;i<obj.length;i++){
					if(obj[i].user_id==id){
						ret = obj[i].nickname+"-"+obj[i].username;
					}
				}
				return ret;
			},
					/**
			 * 获取老人家属用户列表
			 */
			async get_list_user_family_members_of_the_elderly() {
				var json = await this.$get("~/api/user/get_list?user_group=老人家属");
				if(json.result && json.result.list){
					this.list_user_family_members_of_the_elderly = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_family_members_of_the_elderly(id){
				let obj = this.list_user_family_members_of_the_elderly;
				let ret = "";
				for(let i=0;i<obj.length;i++){
					if(obj[i].user_id==id){
						ret = obj[i].nickname+"-"+obj[i].username;
					}
				}
				return ret;
			},
										},
		created() {
				this.get_list_user_elderly_users();
					this.get_list_user_family_members_of_the_elderly();
										},
		async onLoad(){
			if (Object.keys(this.obj_goods).length !== 0) {
				await this.get_obj_goods_type();
				await this.get_obj_by_goods();
			} else if (this.query["elderly_information_id"] !==0) {
				await this.get_obj_by_id();
			}
		}
	}
</script>

<style scoped>
	.div_elderly_information_details {}

	.details {
		background-color: #fff;
		margin-bottom: 0.5rem;
		padding: 1rem;
		font-size: 10px;
	}

	.item {
		display: flex;
		padding: 0.2rem 0;
		border-bottom: 1px solid #eee;
	}

	.left_text {
		flex: 0 0 25%;
	}

	.right_text {
		flex: 0 0 75%;
	}
	.edit_nav{
		text-align: center;
		background-color: #fff;
		padding: 0.3rem;
		margin: 0.1rem 1rem;
		border: 1px solid #eee;
		border-radius: 0.5rem;
	}
</style>
