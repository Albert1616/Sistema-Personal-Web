'use client'

import { Inter } from "next/font/google";
import "./globals.css";
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import React, { useEffect } from "react";
import { useGenerationStore } from "@/lib/state/stateManagament";
import Login from "@/components/login/login";
import { useRouter } from "next/router";


export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {

  const {user} = useGenerationStore();
  const {login, paper} = user;

  return (
    <html lang="en">
      <body>
        {!(paper == '') && <Header/>}
        {children}
        {!(paper == '') && <Footer/>}
      </body>
    </html>
  );
}
