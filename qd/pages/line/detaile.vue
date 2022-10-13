<template>
	<view class="style">
		<div id="title">沿途景点</div>
		<div v-for="(scenicSpot, index) in lineData" :key="index">
			<h3>景点名称:</h3><div class="aaa">{{scenicSpot.scenicName}}</div>
			<h3>景点地点:</h3><div class="aaa">{{scenicSpot.scenicAddress}}</div>
			<h3>景点描述:</h3><div class="aaa">{{scenicSpot.scenicDescribe}}</div>
			<image v-if="scenicSpot.scenicImage" :src="`${backendURL}/img/show/${scenicSpot.scenicImage}`"></image>
		</div>
		<button id="tijiao" @click="toOrder()">提交订单</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				backendURL: this.backendURL,
				id: '',
				lineData:[],
				linename:"",
				price:""

			}
		},
		methods: {
			toOrder(){
				uni.redirectTo({
					url: '../order/order?linename='+this.linename+'&price='+this.price
				})
			}
		},
		onLoad(option) { //option为object类型，会序列化上个页面传递的参数
			console.log(option.price); //打印出上个页面传递的参数。
			console.log(option)
			this.id = option.id;
			this.linename=option.name;
			this.price=option.price;
			
		},
		mounted() {
			this.$axios({
				method: 'get',
				url: '/line/fetchLineDetaile/' + this.id
			}).then(res => {
				this.lineData = res.data;
				console.log(this.lineData, "==================")
			}).catch(err => {
				console.log(err)
			})
		}
	}
</script>

<style>
	.aaa{
		text-indent: 2em;
	}
	.style{
		font-family: "SimSun";
	}
	#title{
		margin-left: 100px;
	},
	#tijiao{
		background-color: #eee;
		border-radius: 15px;
	}
</style>
