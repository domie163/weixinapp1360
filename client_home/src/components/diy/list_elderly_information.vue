<template>
	<view class="list_elderly_information list_com--new" style="background-color: #fff;">
		<!-- 视图 -->
		<view class="elderly_information_block box_wrap" >
			<navigator class="item_elderly_information box_style" v-for="(o, i) in list"  :key="i" :url="'/pages/elderly_information/details?elderly_information_id=' + o['elderly_information_id']">
					<view class="view" v-if="0 && $check_index_field('get','elderly_users','/elderly_information/list')">
					<view class="title" v-if="true">
						<span>老人用户</span>
					</view>
							<view class="diy_field time" >
						<span>{{ get_user_elderly_users(o['elderly_users']) }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','family_members_of_the_elderly','/elderly_information/list')">
					<view class="title" v-if="true">
						<span>老人家属</span>
					</view>
							<view class="diy_field time" >
						<span>{{ get_user_family_members_of_the_elderly(o['family_members_of_the_elderly']) }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','full_name','/elderly_information/list')">
					<view class="title" v-if="true">
						<span>姓名</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["full_name"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','gender','/elderly_information/list')">
					<view class="title" v-if="true">
						<span>性别</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["gender"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','age','/elderly_information/list')">
					<view class="title" v-if="true">
						<span>年龄</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["age"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','id_number','/elderly_information/list')">
					<view class="title" v-if="true">
						<span>身份证号</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["id_number"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','contact_information','/elderly_information/list')">
					<view class="title" v-if="true">
						<span>联系方式</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["contact_information"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','home_address','/elderly_information/list')">
					<view class="title" v-if="true">
						<span>家庭住址</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["home_address"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','remarks','/elderly_information/list')">
					<view class="title" v-if="true">
						<span>备注信息</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["remarks"] }}</span>
					</view>
						</view>
					<view class="bottom-view">
				</view>
				<view class="view">
					<view class="create_time_block diy_field number">
						<span>{{ $toTime(o["create_time"],"yyyy-MM-dd hh:mm:ss") }}</span>
					</view>
				</view>
			</navigator>
		</view>
		<!-- /视图 -->
	</view>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				}
			}
		},
		data() {
			return {
					// 用户列表
				list_user_elderly_users: [],
						// 用户列表
				list_user_family_members_of_the_elderly: [],
											}
		},
		methods: {
			/**
			 *  跳转链接
			 *  @param {Object} id
			 */
			to_nav(id) {
				this.$nav('/pages/elderly_information/details?elderly_information_id=' + id)
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
										}
	}
</script>

<style scoped>
	.list_elderly_information {
		/* padding: 0 1rem; */
		margin-bottom: 1rem;
	}

	.list_elderly_information .list_elderly_information_table {
		width: 100%;
		padding: 5px 0;
	}

	.list_elderly_information .list_elderly_information_table .btn_change_table {
		margin-left: auto;
		font-weight: bold;
		padding: 0.5rem 0;
		width: 100px;
		text-align: center;
		font-size: 0.875rem;
		border: 1px solid #CCCCCC;
		border-radius: 1rem;
		margin-bottom: 0.25rem;
	}

	.list_elderly_information .list_elderly_information_table .elderly_information_table_block .uni-table-td{
		padding: 8px;
	}

	.list_elderly_information .list_elderly_information_table .elderly_information_table_block .image {
		width: 10%;
	}

	.list_elderly_information .list_elderly_information_table .elderly_information_table_block .text {
		overflow: hidden;
		width: 30%;
		font-size: 0.5rem;
	}

	.list_elderly_information .list_elderly_information_table .elderly_information_table_block .hits {
		width: 12%;
		font-size: 0.5rem;
	}

	.list_elderly_information .list_elderly_information_table .elderly_information_table_block .praise {
		width: 12%;
		font-size: 0.5rem;
	}

	.list_elderly_information .list_elderly_information_table .elderly_information_table_block .create_time {
		width: 26%;
		font-size: 0.5rem;
	}
	.list_elderly_information .item_elderly_information {
		display: flex;
		justify-content: space-between;
		align-items: stretch;
		padding: 0.75rem 1rem;

	}
	.list_elderly_information .item_elderly_information+.item_elderly_information{
		border-top: 1px solid #dbdbdb;
	}
	.list_elderly_information .item_elderly_information .left>image {
		position: relative;
		top: 50%;
		transform: translate(0, -50%);
		border-radius: 0.5rem;
	}

	.list_elderly_information .item_elderly_information .right_block {
		width: calc(100% - 5rem);
		display: flex;
		flex-direction: column;
		justify-content: space-between;
	}

	.list_elderly_information .top {
		font-size: 0.9rem;
	}


	.list_elderly_information .time {
		font-size: 0.6rem;
		color: var(--color_grey)
	}

	.list_elderly_information .bottom {
		display: flex;
		justify-content: space-between;
		align-items: baseline;
		font-size: 0.5rem;
		color: var(--color_grey)
	}

	.list_elderly_information .see {
		margin-left: 1rem;
	}
	.box_wrap{
		padding: 0.75rem;
	}
	.box_style{
		margin-bottom: 0.75rem;
		padding: 0.375rem;
		display: inline-block !important;
		border: 0.075rem solid #ccc;
		border-radius: 0.375rem;
		overflow: hidden;
	}
	.box_style:nth-child(even){
		margin-left: 0.60rem;
	}
	.box_style:nth-child(even){
		margin-left: 0.60rem;
	}
	.bottom-view,.create_time_block{
		font-size: 12px;
		color: #666666;
	}
	.bottom-view view{
		display: inline-block;
	}
	.bottom-view span{
		margin-left: 5px;
		margin-right: 10px;
	}
/* new style start */
	.list_com--new .box_wrap{
		display: flex;
		flex-wrap: wrap;
		padding-left: 0 !important;
		padding-right: 0 !important;
		justify-content: space-between;
	}
	.list_com--new .box_style:nth-child(even) {
    	margin-left: 0 !important;
	}
    .list_com--new .box_wrap .box_style{
		display: inline-block !important;
		width: 48%;
		max-width: 48%;
		overflow: hidden;
		border-color: var(--color_primary);
		box-sizing: border-box;
		padding:8px!important;
    }
    .list_com--new .view{
        display: flex;
        overflow: hidden;
		width:100%;
    }

    .list_com--new .view .title span{
       white-space: nowrap;
    }
    .list_com--new .view .text{
        display: flex;
        color: var(--color_primary);
        margin-left: 10px;
        border-bottom: 1px solid #ccc;
        white-space: nowrap;
    }
     .list_com--new .view .text span{
        max-width: 100px;
        overflow: hidden;
        text-overflow: ellipsis;
    }

     .list_com--new .view .number{
        color: var(--color_primary);
    }

    .list_com--new .view .image{
        width: 100%;
        border-bottom: 1px solid #ccc;
		margin-top:5px;
    }

	.list_com--new .diy_field.text{
		overflow: hidden;
		margin-right: -8px;
	}

/* new style start */

</style>

