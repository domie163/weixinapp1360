<template>
	<view class="diy_details diy_div_endowment_insurance">
		<view v-if="Object.keys(obj).length!==0" class="warp">
			<view class="container">
				<view class="row">
					<view v-if="$check_field('get','insurance_name')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>保险名称:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["insurance_name"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','insurance_type')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>保险类型:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["insurance_type"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','cover_photo')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>封面图片:</span>
						</view>
							<view class="diy_field diy_img">
							<image style="width:100%;height:auto;" :src="$fullUrl(obj['cover_photo'])" mode="widthFix"></image>
						</view>
						</view>
					<view v-if="$check_field('get','insurance_price')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>保险价格:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["insurance_price"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','insurance_details')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>保险详情:</span>
						</view>
							<view class="diy_field diy_desc">
							<text>
								{{ obj["insurance_details"] }}
							</text>
						</view>
						</view>
				</view>
			</view>
		</view>

			<view class="warp">
			<view class="container">
				<view class="row">
					<view class="col">
						<button type="button" class="diy_btn" @click="to_form('/pages/elderly_insurance_payment/edit')" v-if="$check_action('/elderly_insurance_payment/edit','add') || $check_action('/elderly_insurance_payment/edit','set')" >老人缴费</button>
					</view>
				</view>
			</view>
		</view>
			<view class="warp">
			<view class="container">
				<view class="row">
					<view class="col">
						<button type="button" class="diy_btn" @click="to_form('/pages/individual_payment/edit')" v-if="$check_action('/individual_payment/edit','add') || $check_action('/individual_payment/edit','set')" >个人缴费</button>
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
						endowment_insurance_id: 0
					}
				}
			}
		},
		data() {
			return {
				obj_goods_type: {},
				obj: {},
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
				var res = await this.$get("~/api/endowment_insurance/get_obj", {
					endowment_insurance_id:this.query.endowment_insurance_id
				})

				if (res.result && res.result.obj) {
					this.obj = res.result.obj
				} else {
					console.log("没有请求到商品分类");
				}
			},
							},
		created() {
							},
		async onLoad(){
			if (Object.keys(this.obj_goods).length !== 0) {
				await this.get_obj_goods_type();
				await this.get_obj_by_goods();
			} else if (this.query["endowment_insurance_id"] !==0) {
				await this.get_obj_by_id();
			}
		}
	}
</script>

<style scoped>
	.div_endowment_insurance_details {}

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
