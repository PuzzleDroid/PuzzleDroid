// @ts-nocheck
import I18nProvider from 'next-translate/I18nProvider'
import React from 'react'
import C, * as _rest from '../pages_'
import ns0 from '../public/static/locales/en/common.json'
import ns1 from '../public/static/locales/en/howto.json'
import ns2 from '../public/static/locales/en/save.json'
import ns3 from '../public/static/locales/en/win.json'

const namespaces = { 'common': ns0, 'howto': ns1, 'save': ns2, 'win': ns3 }

export default function Page(p){
  return (
    <I18nProvider 
      lang="en" 
      namespaces={namespaces}  
      internals={{"defaultLanguage":"en","isStaticMode":true}}
    >
      <C {...p} />
    </I18nProvider>
  )
}

Page = Object.assign(Page, { ...C })

if(C && C.getInitialProps) {
  Page.getInitialProps = ctx => C.getInitialProps({ ...ctx, lang: 'en'})
}


export const getStaticProps = ctx => _rest.getStaticProps({ ...ctx, lang: 'en' })





