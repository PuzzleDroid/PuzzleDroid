import React from "react";
import { Redirect } from "@docusaurus/router";
import useDocusaurusContext from "@docusaurus/useDocusaurusContext";

function Home() {
  const context = useDocusaurusContext();
  const { siteConfig = {} } = context;
  return <Redirect to={`${siteConfig.baseUrl}docs`} />;
}

export default Home;
