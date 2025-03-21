import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},


	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},



	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
		// 文章路由
	{
		path: '/article/table',
		name: 'article_table',
		component: () => import('../views/article/table.vue'),
		meta: {
			index: 0,
			title: '文章列表'
		}
	},
	{
		path: '/article/view',
		name: 'article_view',
		component: () => import('../views/article/view.vue'),
		meta: {
			index: 0,
			title: '文章详情'
		}
	},

	// 文章分类路由
	{
		path: '/article_type/table',
		name: 'article_type_table',
		component: () => import('../views/article_type/table.vue'),
		meta: {
			index: 0,
			title: '文章分类列表'
		}
	},
	{
		path: '/article_type/view',
		name: 'article_type_view',
		component: () => import('../views/article_type/view.vue'),
		meta: {
			index: 0,
			title: '文章分类详情'
		}
	},
	
	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },



	// 公告路由
	{
		path: '/notice/table',
		name: 'notice_table',
		component: () => import('../views/notice/table.vue'),
		meta: {
			index: 0,
			title: '公告信息列表'
		}
	},
	{
		path: '/notice/view',
		name: 'notice_view',
		component: () => import('../views/notice/view.vue'),
		meta: {
			index: 0,
			title: '公告信息详情'
		}
	},


	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},

	// 老人用户路由
	{
		path: '/elderly_users/table',
		name: 'elderly_users_table',
		component: () => import('../views/elderly_users/table.vue'),
		meta: {
			index: 0,
			title: '老人用户列表'
		}
	},
	{
		path: '/elderly_users/view',
		name: 'elderly_users_view',
		component: () => import('../views/elderly_users/view.vue'),
		meta: {
			index: 0,
			title: '老人用户详情'
		}
	},
	// 老人家属路由
	{
		path: '/family_members_of_the_elderly/table',
		name: 'family_members_of_the_elderly_table',
		component: () => import('../views/family_members_of_the_elderly/table.vue'),
		meta: {
			index: 0,
			title: '老人家属列表'
		}
	},
	{
		path: '/family_members_of_the_elderly/view',
		name: 'family_members_of_the_elderly_view',
		component: () => import('../views/family_members_of_the_elderly/view.vue'),
		meta: {
			index: 0,
			title: '老人家属详情'
		}
	},
	// 服务商路由
	{
		path: '/service_provider/table',
		name: 'service_provider_table',
		component: () => import('../views/service_provider/table.vue'),
		meta: {
			index: 0,
			title: '服务商列表'
		}
	},
	{
		path: '/service_provider/view',
		name: 'service_provider_view',
		component: () => import('../views/service_provider/view.vue'),
		meta: {
			index: 0,
			title: '服务商详情'
		}
	},
	// 服务分类路由
	{
		path: '/service_classification/table',
		name: 'service_classification_table',
		component: () => import('../views/service_classification/table.vue'),
		meta: {
			index: 0,
			title: '服务分类列表'
		}
	},
	{
		path: '/service_classification/view',
		name: 'service_classification_view',
		component: () => import('../views/service_classification/view.vue'),
		meta: {
			index: 0,
			title: '服务分类详情'
		}
	},
	// 养老保险路由
	{
		path: '/endowment_insurance/table',
		name: 'endowment_insurance_table',
		component: () => import('../views/endowment_insurance/table.vue'),
		meta: {
			index: 0,
			title: '养老保险列表'
		}
	},
	{
		path: '/endowment_insurance/view',
		name: 'endowment_insurance_view',
		component: () => import('../views/endowment_insurance/view.vue'),
		meta: {
			index: 0,
			title: '养老保险详情'
		}
	},
	// 老人保险缴费路由
	{
		path: '/elderly_insurance_payment/table',
		name: 'elderly_insurance_payment_table',
		component: () => import('../views/elderly_insurance_payment/table.vue'),
		meta: {
			index: 0,
			title: '老人保险缴费列表'
		}
	},
	{
		path: '/elderly_insurance_payment/view',
		name: 'elderly_insurance_payment_view',
		component: () => import('../views/elderly_insurance_payment/view.vue'),
		meta: {
			index: 0,
			title: '老人保险缴费详情'
		}
	},
	// 个人缴费路由
	{
		path: '/individual_payment/table',
		name: 'individual_payment_table',
		component: () => import('../views/individual_payment/table.vue'),
		meta: {
			index: 0,
			title: '个人缴费列表'
		}
	},
	{
		path: '/individual_payment/view',
		name: 'individual_payment_view',
		component: () => import('../views/individual_payment/view.vue'),
		meta: {
			index: 0,
			title: '个人缴费详情'
		}
	},
	// 老人信息路由
	{
		path: '/elderly_information/table',
		name: 'elderly_information_table',
		component: () => import('../views/elderly_information/table.vue'),
		meta: {
			index: 0,
			title: '老人信息列表'
		}
	},
	{
		path: '/elderly_information/view',
		name: 'elderly_information_view',
		component: () => import('../views/elderly_information/view.vue'),
		meta: {
			index: 0,
			title: '老人信息详情'
		}
	},
	// 生活服务路由
	{
		path: '/life_services/table',
		name: 'life_services_table',
		component: () => import('../views/life_services/table.vue'),
		meta: {
			index: 0,
			title: '生活服务列表'
		}
	},
	{
		path: '/life_services/view',
		name: 'life_services_view',
		component: () => import('../views/life_services/view.vue'),
		meta: {
			index: 0,
			title: '生活服务详情'
		}
	},
	// 预约订单路由
	{
		path: '/appointment_order/table',
		name: 'appointment_order_table',
		component: () => import('../views/appointment_order/table.vue'),
		meta: {
			index: 0,
			title: '预约订单列表'
		}
	},
	{
		path: '/appointment_order/view',
		name: 'appointment_order_view',
		component: () => import('../views/appointment_order/view.vue'),
		meta: {
			index: 0,
			title: '预约订单详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "社区养老保障系统小程序-admin";
	document.title = title;
})

export default router
