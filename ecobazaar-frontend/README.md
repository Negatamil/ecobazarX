# EcoBazaarX Frontend

A premium, production-ready React frontend for the EcoBazaarX Carbon Footprint Aware Shopping Assistant.

## 🌱 Features

- **Modern UI/UX**: Premium design with Tailwind CSS and ShadCN UI components
- **Responsive Design**: Fully responsive across desktop and mobile devices
- **Smooth Animations**: Framer Motion animations for enhanced user experience
- **Real API Integration**: Connected to EcoBazaarX backend with comprehensive error handling
- **Carbon Footprint Display**: Visual representation of environmental impact data
- **Product Filtering**: Filter by categories and sort by carbon footprint
- **Shopping Cart**: Add to cart functionality with real-time updates
- **User Authentication**: Login/logout with role-based access

## 🚀 Tech Stack

- **React 18** - Modern React with hooks
- **Vite** - Fast build tool and dev server
- **Tailwind CSS** - Utility-first CSS framework
- **ShadCN UI** - High-quality component library
- **Framer Motion** - Smooth animations and transitions
- **Axios** - HTTP client for API calls
- **React Router** - Client-side routing
- **Lucide React** - Beautiful icons

## 📦 Installation

1. Navigate to the frontend directory:
```bash
cd ecobazaar-frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```

4. Open your browser and visit `http://localhost:3000`

## 🔧 Configuration

The frontend is configured to proxy API calls to the backend running on `http://localhost:8080`. Make sure your EcoBazaarX backend is running before starting the frontend.

## 🎨 Design System

### Colors
- **Primary**: Eco-green palette (#22c55e to #15803d)
- **Secondary**: Clean grays and whites
- **Accent**: Blue and cyan for water/energy metrics

### Components
- **Cards**: Glass-morphism effect with subtle shadows
- **Buttons**: Multiple variants including eco-themed gradient buttons
- **Inputs**: Clean, accessible form inputs
- **Animations**: Smooth fade-in, slide, and hover effects

## 📱 Responsive Breakpoints

- **Mobile**: < 768px
- **Tablet**: 768px - 1024px
- **Desktop**: > 1024px

## 🔌 API Integration

All backend endpoints are integrated:
- User authentication and management
- Product catalog with filtering and sorting
- Category management
- Order placement and history
- Carbon footprint data display
- Recommendations system

## 🚀 Production Build

```bash
npm run build
```

The build artifacts will be stored in the `dist/` directory.

## 🌟 Key Features Implemented

1. **Hero Section**: Engaging landing with call-to-action
2. **Product Grid**: Responsive grid with carbon footprint cards
3. **Filtering System**: Category and carbon footprint sorting
4. **Shopping Cart**: Add to cart with counter
5. **User Authentication**: Login/logout functionality
6. **Responsive Header**: Mobile-friendly navigation
7. **Loading States**: Skeleton loaders for better UX
8. **Error Handling**: Graceful error management
9. **Premium Animations**: Smooth Framer Motion effects
10. **SEO Optimized**: Proper meta tags and structure

## 🎯 Next Steps

- Add product detail pages
- Implement checkout flow
- Add user dashboard
- Integrate payment processing
- Add more filtering options
- Implement real-time notifications

Built with 💚 for sustainable shopping!